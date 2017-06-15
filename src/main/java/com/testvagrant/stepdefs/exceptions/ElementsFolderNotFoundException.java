package com.testvagrant.stepdefs.exceptions;


import com.testvagrant.commons.exceptions.OptimusException;

public class ElementsFolderNotFoundException extends OptimusException {


    public ElementsFolderNotFoundException(String appName) {
        super(String.format("Cannot find elements folder for project %s. Elements should be created under respective app folders.",appName));
    }
}
