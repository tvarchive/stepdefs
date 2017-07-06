package com.testvagrant.stepdefs.exceptions;

import com.testvagrant.commons.exceptions.OptimusException;

/**
 * Created by krishnanand on 03/07/17.
 */
public class NoMatchingStepFoundException extends OptimusException {

    public NoMatchingStepFoundException(String step) {
        super(String.format("Unable to find any step definition matching step '%s'",step));
    }

}
