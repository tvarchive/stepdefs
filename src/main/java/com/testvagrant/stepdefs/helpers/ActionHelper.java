package com.testvagrant.stepdefs.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionHelper {

    protected WebDriver driver;
    private WebDriverWait webDriverWait;
    ActionHelper(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver,30);
    }

    void waitForElementToBeClickable(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));

    }

    void waitForElementToBeVisible(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
}
