package com.testvagrant.stepdefs.exceptions;


public class ElementsFileNotFoundException extends RuntimeException {

    public ElementsFileNotFoundException(String appName ,String fileName, String fileExtension) {
        super(String.format("Unable to find '%s%s' in '/resources/elements/%s' path. Are the elements properly created? " +
                "Please refer to Elements Github link https://github.com/testvagrant/optimusTemplate/wiki/How-to-create-an-object-repository",fileName,fileExtension,appName));
    }
}
