package com.testvagrant.stepdefs.exceptions;

import com.testvagrant.commons.exceptions.OptimusException;


public class InvalidElementsFormatException extends OptimusException {

    public InvalidElementsFormatException(String elementFormat, String values) {
        super(String.format("'%s' is an invalid format. Acceptable formats are %s",elementFormat, values));
    }
}
