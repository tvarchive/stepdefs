package com.testvagrant.stepdefs.finder;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class WaitControl {

    private AppiumDriver driver;
    Map<String, WaitFor> waitForMap = new HashMap<>();


    public WaitControl(AppiumDriver driver) {
        this.driver = driver;
        waitForMap.put("presence", new WaitForPresence());
        waitForMap.put("visibility", new WaitForVisibility());
        waitForMap.put("clickability", new WaitForClickability());
    }


    public void waitFor(String waitFor, By locator) {
        waitForMap.get(waitFor).waitForElement(driver, locator);
    }
}
