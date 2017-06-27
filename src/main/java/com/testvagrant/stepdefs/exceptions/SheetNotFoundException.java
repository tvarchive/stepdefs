package com.testvagrant.stepdefs.exceptions;


import com.testvagrant.commons.exceptions.OptimusException;

public class SheetNotFoundException extends OptimusException {
    public SheetNotFoundException(String sheetName, String fileName) {
        super(String.format("Cannot find sheet `%s` in file `%s`",sheetName,fileName));
    }
}
