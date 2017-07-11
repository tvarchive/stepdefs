package com.testvagrant.stepdefs.helpers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
        webDriverWait = new WebDriverWait(driver,30);
        touchAction = new TouchAction(driver);
    }


    void waitForElementToBeClickable(WebElement element) {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (WebDriverException e) {
            Thread.currentThread().interrupt();
        }

    }

    void waitForElementToBeVisible(WebElement element) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
        } catch (WebDriverException e) {
            Thread.currentThread().interrupt();
        }
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

    boolean isElementPresent(By by) {
        System.out.println("Came here");
        try {
            webDriverWait = new WebDriverWait(driver,10);
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
            WebElement element = driver.findElement(by);
            return element.getSize().getHeight()>0 && element.getSize().getWidth()>0;
        } catch (NoSuchElementException e) {
            return false;
        } catch (WebDriverException e) {
            Thread.currentThread().interrupt();
        }
        return false;
    }

    boolean isElementVisible(By by) {
        System.out.println("Came here for visibility");
        try {
            webDriverWait = new WebDriverWait(driver,10);
            webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
            WebElement element = driver.findElement(by);
            return element.getSize().getHeight()>0 && element.getSize().getWidth()>0;
        } catch (NoSuchElementException e) {
            return false;
        } catch (WebDriverException e) {
            Thread.currentThread().interrupt();
        }
        return false;
    }

}
