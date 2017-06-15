package com.testvagrant.stepdefs.exceptions;


public class NoSuchEventException extends Exception {

    public NoSuchEventException(String action) {
        super(String.format("Cannot find any event by name '%s', check if there is a typo error or look for supported events in EventReadme link",action));
    }

}
