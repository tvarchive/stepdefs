package com.testvagrant.stepdefs.exceptions;

/**
 * Created by krishnanand on 03/07/17.
 */
public class NoMatchingStepFoundException extends RuntimeException {

    public NoMatchingStepFoundException(String step) {
        super(String.format("Unable to find any step definition matching step '%s'",step));
    }

}
