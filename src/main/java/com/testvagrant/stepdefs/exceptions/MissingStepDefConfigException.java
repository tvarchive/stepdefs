package com.testvagrant.stepdefs.exceptions;


public class MissingStepDefConfigException extends RuntimeException {

    public MissingStepDefConfigException() {
        super("Unable to find a file with '.yaml' extension in resources/META-INF folder. Create one to proceed");
    }
}
