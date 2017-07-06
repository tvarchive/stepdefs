package com.testvagrant.stepdefs.utils;


import com.testvagrant.stepdefs.exceptions.NoMatchingStepFoundException;
import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import cucumber.runtime.Utils;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MethodRunner {

    private static Map<String, Method> patterns;
    private static boolean patternFound;
    private Set<Method> allCucumberMethods;
    private Reflections reflections;
    private Matcher matcher;
    private DataTable dataTable;
    private static List<String> overRideData;
    private MethodRunner() {
        patterns = new HashMap<>();
        allCucumberMethods = new HashSet<>();
        overRideData = new ArrayList<>();
    }

    public static MethodRunner methodRunner() {
        return new MethodRunner();
    }

    public MethodRunner useData(DataTable dataTable) {
        this.dataTable = dataTable;
        overRideData.addAll(dataTable.cells(0).get(0));
        return this;
    }

    public void exec(String name) throws NoMatchingStepFoundException {
        findPatterns().ifNotFound();
        String pattern = findMatchingPattern(name);
        Method method = patterns.get(pattern);
        List<String> args = getData();
        try {
            if(method.getParameterCount()>0) {
                Utils.invoke(method.getDeclaringClass().newInstance(), method, 200, args.toArray());
            }
            else {
                Utils.invoke(method.getDeclaringClass().newInstance(), method, 200);
            }
        } catch (Throwable throwable) {

        }
    }

    private MethodRunner findPatterns() {
        if(!patternFound) {
            reflections = new Reflections("steps", new MethodAnnotationsScanner());
            allCucumberMethods = reflections.getMethodsAnnotatedWith(Given.class);
            allCucumberMethods.addAll(reflections.getMethodsAnnotatedWith(When.class));
            allCucumberMethods.addAll(reflections.getMethodsAnnotatedWith(Then.class));
            allCucumberMethods.addAll(reflections.getMethodsAnnotatedWith(And.class));
            allCucumberMethods.addAll(reflections.getMethodsAnnotatedWith(But.class));
            allCucumberMethods.forEach(method -> {
                Arrays.stream(method.getDeclaredAnnotations()).forEach(annotation -> {
                    readPattern(method, annotation);
                });
            });
        }
        return this;
    }

    public void ifNotFound() {
        if(patterns.size()>0) {
            patternFound = true;
        }
    }

    private void readPattern(Method method, Annotation annotation) {
        if (annotation instanceof Given) {
            patterns.put(((Given) annotation).value(), method);
        } else if (annotation instanceof When) {
            patterns.put(((When) annotation).value(), method);
        } else if (annotation instanceof Then) {
            patterns.put(((Then) annotation).value(), method);
        } else if (annotation instanceof And) {
            patterns.put(((And) annotation).value(), method);
        } else if (annotation instanceof But) {
            patterns.put(((But) annotation).value(), method);
        }
    }


    private String findMatchingPattern(String name) throws NoMatchingStepFoundException {
        Optional<String> first = patterns.keySet().stream().filter(pattern -> {
            Pattern pattern1 = Pattern.compile(pattern);
            matcher = pattern1.matcher(name);
            return matcher.matches();
        }).findFirst();
        if(first.isPresent()) {
            return first.get();
        }
        throw new NoMatchingStepFoundException(name);
    }



    private List<String> getData() {
        List<String> args = new ArrayList<>();
        if(dataTable==null) {
            for (int groupIndex = 1; groupIndex <= matcher.groupCount(); groupIndex++) {
                args.add(matcher.group(groupIndex));
            }
        } else {
                int matches = matcher.groupCount() - 1;
                if(matches>0) {
                    for (int index = 0; index <= matches; index++) {
                        args.add(overRideData.get(index));
                    }
                    for (int index = 0; index <= matches; index++) {
                        overRideData.remove(0);
                    }
                }
        }
        return args;
    }
}
