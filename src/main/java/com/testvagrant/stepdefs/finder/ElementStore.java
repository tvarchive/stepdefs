package com.testvagrant.stepdefs.finder;

import com.google.gson.Gson;
import com.testvagrant.commons.exceptions.OptimusException;
import com.testvagrant.optimus.utils.JsonUtil;
import com.testvagrant.stepdefs.exceptions.*;
import com.testvagrant.stepdefs.utils.LocatorsFileFormat;

import java.io.File;
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
    private ElementStore(String appName) {
        this.appName = formatAppName(appName);
    }

    public static ElementStore elementStore(String appName) {
        return new ElementStore(appName);
    }

    public ElementStore read(String screenName) throws OptimusException {
        this.fileFound = false;
        this.screenName = screenName;
        this.fileName = getFileName();
        return this;
    }

    public Element find(String fieldName) throws OptimusException, IOException {
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


    private Element findElementByReference(Element element) throws OptimusException, IOException {
        read("CommonElements");
        return find(element.getReferTo());
    }





    private App getApp() throws InvalidElementsFormatException, IOException, SheetNotFoundException {
        switch (getFileFormat()) {
            case ELEMENTS:case JSON:
                String appJson = new JsonUtil().getAppJson(fileName);
                app = new Gson().fromJson(appJson, App.class);
                break;
            case XLS:case XLSX:
                app = converter(appName).withExtension(getFileExtension()).convert(screenName);
                break;
        }

        return app;
    }

    private String getFileName() throws OptimusException {
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

    private String getElementsFileRelativePath(File file) throws OptimusException {
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


    private void throwRelevantException(String fieldName) throws InvalidElementsFormatException, ElementNotPresentException {
        String keyWord =null;
        switch (getFileFormat()) {
            case JSON:
                keyWord = "elements file";
                break;
            case ELEMENTS:
                keyWord="json file";
                break;
            case XLS:case XLSX:
                keyWord="excel sheet";
                break;
        }
        throw new ElementNotPresentException(String.format("Element %s is not found in %s %s",fieldName,keyWord,screenName));
    }
}
