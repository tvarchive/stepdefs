package com.testvagrant.stepdefs.helpers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionHelper {

    protected AppiumDriver driver;
    private WebDriverWait webDriverWait;
    TouchAction touchAction;
    ActionHelper(AppiumDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver,10);
        touchAction = new TouchAction(driver);
    }


    void waitForElementToBeClickable(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    void waitForElementToBeVisible(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    void hideKeyboard() {
        try {
            driver.hideKeyboard();
        } catch (WebDriverException ignored) {


        }
    }

    int getHeight() {
        int height = driver.manage().window().getSize().getHeight();
        return height;
    }

    int getWidth() {
        int width = driver.manage().window().getSize().getWidth();
        return width;
    }


    int getInt(String percentage) {
        String strWithoutPercentage = percentage.replaceAll("\\%","").trim();
        return Integer.parseInt(strWithoutPercentage);
    }


}
