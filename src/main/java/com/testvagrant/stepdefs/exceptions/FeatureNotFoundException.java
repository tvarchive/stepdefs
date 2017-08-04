package com.testvagrant.stepdefs.exceptions;


public class FeatureNotFoundException extends RuntimeException {

    public FeatureNotFoundException(String intentId) {
        super(String.format("Cannot find any feature with intent '%s'",intentId));
    }
}
