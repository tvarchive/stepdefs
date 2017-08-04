package com.testvagrant.stepdefs.finder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class WaitControl {

    private WebDriver driver;
    Map<String, WaitFor> waitForMap = new HashMap<>();


    public WaitControl(WebDriver driver) {
        this.driver = driver;
        waitForMap.put("presence", new WaitForPresence());
        waitForMap.put("visibility", new WaitForVisibility());
        waitForMap.put("clickability", new WaitForClickability());
    }


    public void waitFor(String waitFor, By locator) {
        waitForMap.get(waitFor).waitForElement(driver, locator);
    }
}
