package com.testvagrant.stepdefs.helpers;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class SwipeHelper extends ActionHelper{

    private SwipeHelper(AppiumDriver driver) {
        super(driver);
    }


    public static SwipeHelper swiper(AppiumDriver driver) {
        return new SwipeHelper(driver);
    }

    public void swipeLeft(WebElement webElement) {
        int count = 0;
        while (count < 12) {
            left();
            if (webElement.isDisplayed()) {
                return;
            }
            count++;
        }
    }

    public void swipeRight(WebElement webElement) {
        int count = 0;
        while (count < 12) {
            right();
            if (webElement.isDisplayed()) {
                return;
            }
            count++;
        }
    }

    private void left() {
        driver.swipe(getWidth() / 10, getHeight() / 2, getWidth() * 9 / 10, getHeight() / 2, 1000);
    }

    private void right() {
        driver.swipe(getWidth() * 9 / 10, getHeight() / 2, getWidth() / 10, getHeight() / 2, 1000);
    }


}
