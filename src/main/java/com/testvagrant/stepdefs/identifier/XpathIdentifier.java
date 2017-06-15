package com.testvagrant.stepdefs.identifier;

import org.openqa.selenium.By;

public class XpathIdentifier implements ElementIdentifier {

    @Override
    public By getLocator(String value) {
        return By.xpath(value);
    }
}
