package com.testvagrant.stepdefs.helpers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionHelper {

    protected AppiumDriver driver;
    private WebDriverWait webDriverWait;


    public ActionHelper(AppiumDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 30);
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
        String strWithoutPercentage = percentage.replaceAll("\\%", "").trim();
        return Integer.parseInt(strWithoutPercentage);
    }

    boolean isElementPresent(By by) {
        try {
            synchronized (this) {
                webDriverWait = new WebDriverWait(driver, 30);
                webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
            }
            WebElement element = driver.findElement(by);
            return element.getSize().getHeight() > 0 && element.getSize().getWidth() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    boolean isElementVisible(By by) {
        try {
            webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
            WebElement element = driver.findElement(by);
            return element.getSize().getHeight() > 0 && element.getSize().getWidth() > 0;
        } catch (Exception e) {
            return false;
        }
    }

}
