package com.testvagrant.stepdefs.finder;

import com.google.gson.Gson;
import com.testvagrant.stepdefs.entities.StepDefsConfiguration;
import com.testvagrant.stepdefs.exceptions.*;
import com.testvagrant.stepdefs.utils.ConfigParser;
import com.testvagrant.stepdefs.utils.LocatorsFileFormat;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static com.testvagrant.stepdefs.utils.ExcelToObjectConverter.converter;
import static com.testvagrant.stepdefs.utils.LocatorsFileFormat.locatorsFF;

public class ElementStore {
    private boolean fileFound;
    private String filePath;
    private String screenName;
    private String appName;
    private String fileName;
    private String fileExtension;
    private static App app;
    private ElementStore() {
        this.appName = getAppName();
    }

    public static ElementStore elementStore() {
        return new ElementStore();
    }

    public ElementStore read(String screenName) {
        this.fileFound = false;
        this.screenName = screenName;
        this.fileName = getFileName();
        return this;
    }

    public Element find(String fieldName) throws IOException {
        Element foundElement =null;
        List<Element> elements = getApp().getElements();
        Optional<Element> first = elements.stream()
                .filter(element -> element.getElementName().equalsIgnoreCase(fieldName)).findFirst();
        if(first.isPresent()) {
            foundElement = first.get();
            if(foundElement.getReferTo()!=null && foundElement.getReferTo().length()>0) {
                return findElementByReference(foundElement);
            }
        } else {
            throwRelevantException(fieldName);
        }
        return foundElement;
    }


    private Element findElementByReference(Element element) throws  IOException {
        read("CommonElements");
        return find(element.getReferTo());
    }

    private App getApp() throws InvalidElementsFormatException, IOException, SheetNotFoundException {
        switch (getFileFormat()) {
            case ELEMENTS:case JSON:
                String appJson = getAppJson(fileName);
                app = new Gson().fromJson(appJson, App.class);
                break;
            case XLS:case XLSX:
                app = converter(appName).withExtension(getFileExtension()).convert(screenName);
                break;
        }

        return app;
    }

    private String getFileName() {
        String fileName =null;
        switch (getFileFormat()) {
            case ELEMENTS:case JSON:
                fileName = getElementsFileRelativePath(new File(System.getProperty("user.dir") + "/src/test/resources/elements/"+appName));
                if(fileName==null) {
                    throw new ElementsFileNotFoundException(appName,screenName,fileExtension);
                }
                break;
            case XLS:case XLSX:
                fileName = appName;
                break;
        }
        return fileName;
    }

    private String formatAppName(String appName) {
        if(appName.contains("apk")||appName.contains("ipa")||appName.contains("app")) {
            return appName.substring(0,appName.indexOf(".")).toLowerCase();
        }
        return appName.toLowerCase();
    }

    private String getElementsFileRelativePath(File file) {
        if(file.exists() && file.isDirectory() && !fileFound) {
            File[] jsons = file.listFiles();
            for(File json : jsons) {
                if(!json.isDirectory()) {
                    fileFound = json.getName().equalsIgnoreCase(screenName+getFileExtension());
                    if(fileFound) {
                        String absPath = json.getPath();
                        try {
                            int index = absPath.indexOf("/elements/" + appName);
                            filePath = absPath.substring(index,absPath.length());
                        } catch (Exception e) {
                            throw new ElementsFolderNotFoundException(appName);
                        }

                        break;
                    }
                } else {
                    String val = getElementsFileRelativePath(json);
                    if(val!=null) {
                        break;
                    }
                }
            }
        } else {
            throw new ElementsFolderNotFoundException(appName);
        }
        return filePath;
    }


    private String getFileExtension() throws InvalidElementsFormatException {
        fileExtension = locatorsFF().getFormat().getFormatExtension();
        return fileExtension;
    }

    private LocatorsFileFormat.LocFileFormats getFileFormat() throws InvalidElementsFormatException {
        return locatorsFF().getFormat();
    }


    private String getAppName() {
        StepDefsConfiguration stepDefsConfiguration = new ConfigParser().getConfiguration();
        String elementsFolderName = stepDefsConfiguration.getElementsFolderName();
        if(elementsFolderName==null) {
            throw new MissingElementsFolderNameException();
        }
        return elementsFolderName;
    }


    private void throwRelevantException(String fieldName) throws InvalidElementsFormatException, ElementNotPresentException {
        String keyWord =null;
        switch (getFileFormat()) {
            case JSON:
                keyWord = "json file";
                break;
            case ELEMENTS:
                keyWord="elements file";
                break;
            case XLS:case XLSX:
                keyWord="excel sheet";
                break;
        }
        throw new ElementNotPresentException(String.format("Element %s is not found in %s %s",fieldName,keyWord,screenName));
    }

    public String getAppJson(String name) {
        String result = "";
        try {
            result = IOUtils.toString(new FileInputStream(
                    new File(System.getProperty("user.dir") + "/src/test/resources/" + name)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
