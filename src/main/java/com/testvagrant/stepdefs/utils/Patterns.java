package com.testvagrant.stepdefs.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patterns {

    private String line;
    private Matcher matcher;
    private PatternType patternType;
    private Patterns(String line) {
        this.line = line;
        matchPattern();
    }

    public static Patterns patterns(String line) {
        return new Patterns(line);
    }

    public PatternType getPattern() {
        return patternType;
    }

    public Matcher getMatcher() {
        return matcher;
    }

    private void matchPattern() {
        if(isPatternMatched(action())) {
            patternType = PatternType.ACTION;
        } else if(isPatternMatched(actionWithValue())) {
            patternType = PatternType.ACTION_WITH_VALUE;
        } else if(isPatternMatched(assertion())) {
            patternType = PatternType.ASSERTION;
        } else if(isPatternMatched(assertionWithValue())) {
            patternType = PatternType.ASSERTION_WITH_VALUE;
        }
        throw new RuntimeException("Cannot find matching pattern");
    }

    private static String action() {
        return "^(\\w+)\\s+on\\s+(\\w+)\\s+screen\\s+(\\w+)\\s+on\\s+(\\w+)$";
    }

    private static String actionWithValue() {
        return "^(\\w+)\\s+on\\s+(\\w+)\\s+screen\\s+(\\w+)\\s+on\\s+(\\w+)\\s+value\\s+(.*)$";
    }

    private static String assertion() {
        return "^(\\w+)\\s+on\\s+(\\w+)\\sscreen verifies\\s+(\\w+)\\s+is\\s+(.*)$";
    }

    private static String assertionWithValue() {
        return "^(\\w+)\\s+on\\s+(\\w+)\\sscreen verifies\\s+(\\w+)\\s+has\\s+(\\w+)\\s+value\\s+(.*)$";
    }


    private boolean isPatternMatched(String regex) {
        Pattern pattern = Pattern.compile(regex);
        matcher = pattern.matcher(line);
        return matcher.matches();
    }
}
