package com.testvagrant.stepdefs.finder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by sukeshkumar on 30/05/17.
 */
public interface WaitFor {

    void waitForElement(WebDriver driver, By Locator);
}
