package com.testvagrant.stepdefs.exceptions;


public class ElementsFolderNotFoundException extends RuntimeException {


    public ElementsFolderNotFoundException(String appName) {
        super(String.format("Cannot find elements folder for project %s. Elements should be created under respective app folders.",appName));
    }
}
