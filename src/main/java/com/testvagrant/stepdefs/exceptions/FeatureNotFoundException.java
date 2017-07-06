package com.testvagrant.stepdefs.exceptions;


import com.testvagrant.commons.exceptions.OptimusException;

public class FeatureNotFoundException extends OptimusException {

    public FeatureNotFoundException(String intentId) {
        super(String.format("Cannot find any feature with intent '%s'",intentId));
    }
}
