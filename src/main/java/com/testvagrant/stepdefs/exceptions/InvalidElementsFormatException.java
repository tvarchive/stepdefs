package com.testvagrant.stepdefs.exceptions;

public class InvalidElementsFormatException extends RuntimeException {

    public InvalidElementsFormatException(String elementFormat, String values) {
        super(String.format("'%s' is an invalid format. Acceptable formats are %s",elementFormat, values));
    }
}
