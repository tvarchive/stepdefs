package com.testvagrant.stepdefs.identifier;

import org.openqa.selenium.By;

public class LinkIdentifier implements ElementIdentifier {

    @Override
    public By getLocator(String value) {
        return By.linkText(value);
    }
}
