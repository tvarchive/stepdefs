package com.testvagrant.stepdefs.finder;

import com.google.gson.Gson;
import com.testvagrant.commons.exceptions.OptimusException;
import com.testvagrant.optimus.utils.JsonUtil;
import com.testvagrant.stepdefs.exceptions.ElementNotPresentException;
import com.testvagrant.stepdefs.exceptions.ElementsFileNotFoundException;
import com.testvagrant.stepdefs.exceptions.ElementsFolderNotFoundException;
import com.testvagrant.stepdefs.exceptions.InvalidElementsFormatException;

import java.io.File;
import java.util.List;
import java.util.Optional;

import static com.testvagrant.stepdefs.utils.LocatorsFileFormat.locatorsFF;

public class ElementStore {

    UIElement uiElement;
    private boolean fileFound;
    private String filePath;

    private String screenName;
    private String appName;
    private String fileName;
    private String fileExtension;
    private ElementStore(String appName) {
        this.appName = appName;
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

    public Element find(String fieldName) throws OptimusException {
        Element foundElement =null;
        List<Element> elements = getApp().getElements();
        Optional<Element> first = elements.stream()
                .filter(element -> element.getElementName().equalsIgnoreCase(fieldName)).findFirst();
        if(first.isPresent()) {
            foundElement = first.get();
            if(foundElement.getReferTo()!=null) {
                return findElementByReference(foundElement);
            }
        } else {
            throw new ElementNotPresentException(String.format("Element %s is not found in file %s",fieldName,fieldName));
        }
        return foundElement;
    }


    private Element findElementByReference(Element element) throws OptimusException {
        read("CommonElements");
        return find(element.getReferTo());
    }





    private App getApp() {
        String appJson = new JsonUtil().getAppJson(fileName);
        App app = new Gson().fromJson(appJson, App.class);
        return app;
    }

    private String getFileName() throws OptimusException {
        String fileName = getElementsFileRelativePath(new File(System.getProperty("user.dir") + "/src/test/resources/elements/"+getAppName()));
        if(fileName==null) {
            throw new ElementsFileNotFoundException(getAppName(),screenName,fileExtension);
        }
        return fileName;
    }

    private String getAppName() {
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
                            int index = absPath.indexOf("/elements/" + getAppName());
                            filePath = absPath.substring(index,absPath.length());
                        } catch (Exception e) {
                            throw new ElementsFolderNotFoundException(getAppName());
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
            throw new ElementsFolderNotFoundException(getAppName());
        }
        return filePath;
    }


    private String getFileExtension() throws InvalidElementsFormatException {
        fileExtension = locatorsFF().getFormat();
        return fileExtension;
    }
}
