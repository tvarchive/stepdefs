package com.testvagrant.stepdefs.helpers;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class TapHelper extends ActionHelper {


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
        new TouchAction(driver).tap((tapOptions().withElement(element(element)))).release().perform()
                .tap((tapOptions().withElement(element(element)))).release().perform();
    }
}
