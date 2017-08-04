package com.testvagrant.stepdefs.exceptions;


public class SheetNotFoundException extends RuntimeException {
    public SheetNotFoundException(String sheetName, String fileName) {
        super(String.format("Cannot find sheet `%s` in file `%s`",sheetName,fileName));
    }
}
