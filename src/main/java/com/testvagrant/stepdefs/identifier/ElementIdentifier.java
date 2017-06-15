package com.testvagrant.stepdefs.identifier;

import org.openqa.selenium.By;

/**
 * Created by sukeshkumar on 30/05/17.
 */
public interface ElementIdentifier {

    public By getLocator(String value);
}
