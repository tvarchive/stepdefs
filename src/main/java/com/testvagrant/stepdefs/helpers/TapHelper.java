package com.testvagrant.stepdefs.helpers;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class TapHelper extends ActionHelper {


    private AppiumDriver appiumDriver;
    private TapHelper(AppiumDriver driver) {
        super(driver);
    }

    public static TapHelper tapHelper(AppiumDriver appiumDriver) {
        return new TapHelper(appiumDriver);
    }

    public void tap(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    public void doubleTap(WebElement element) {
        waitForElementToBeClickable(element);
        touchAction.tap(element).release().perform()
                .tap(element).release().perform();
    }
}
