package com.testvagrant.stepdefs.helpers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

public class NavigationHelper extends ActionHelper {

    private NavigationHelper(AppiumDriver driver) {
        super(driver);
    }

    public static NavigationHelper navigator(AppiumDriver driver) {
        return new NavigationHelper(driver);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateForward() {
        driver.navigate().forward();
    }

    public void refresh() {
        new TouchAction(driver).press(point(5, getHeight() / 3))
                .waitAction(waitOptions(Duration.ofMillis(1000)))
                .moveTo(point(5, getHeight() * 2 / 3))
                .release().perform();
    }

    public void hideKeyBoard() {
        driver.hideKeyboard();
    }
}
