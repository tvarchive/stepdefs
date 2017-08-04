package com.testvagrant.stepdefs.exceptions;

/**
 * Created by krishnanand on 01/08/17.
 */
public class MissingElementsFolderNameException extends RuntimeException {

    public MissingElementsFolderNameException() {
        super("Cannot find property 'elementsFolderName' in configuration file under 'resources/META-INF', it is a mandatory property. " +
                "Elements folder name is usually the name of folder for storing elements in 'resources/Elements' folder. ");
    }
}
