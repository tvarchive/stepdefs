package com.testvagrant.stepdefs.identifier;

import org.openqa.selenium.By;

public class ClassNameIdentifier implements ElementIdentifier {

    @Override
    public By getLocator(String value) {
        return By.className(value);
    }
}
