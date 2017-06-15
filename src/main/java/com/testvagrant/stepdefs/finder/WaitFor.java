package com.testvagrant.stepdefs.finder;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * Created by sukeshkumar on 30/05/17.
 */
public interface WaitFor {

    void waitForElement(AppiumDriver driver, By Locator);
}
