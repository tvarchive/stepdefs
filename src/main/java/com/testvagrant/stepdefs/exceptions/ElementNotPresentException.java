package com.testvagrant.stepdefs.exceptions;

import com.testvagrant.commons.exceptions.OptimusException;

/**
 * Created by krishnanand on 13/06/17.
 */
public class ElementNotPresentException extends OptimusException {

    public ElementNotPresentException(String message) {
        super(message);
    }
}
