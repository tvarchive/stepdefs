package com.testvagrant.stepdefs.helpers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickHelper extends ActionHelper {


    ClickHelper(WebDriver driver) {
        super(driver);
    }

    public static ClickHelper clickHelper(WebDriver driver) {
        return new ClickHelper(driver);
    }

    public void click(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    public void doubleClick(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        element.click();
    }
}
