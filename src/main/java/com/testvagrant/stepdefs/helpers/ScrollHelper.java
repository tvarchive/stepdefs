package com.testvagrant.stepdefs.helpers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;


public class ScrollHelper extends ActionHelper {

    protected ScrollHelper(AppiumDriver driver) {
        super(driver);
    }

    public static ScrollHelper scroller(AppiumDriver driver) {
        return new ScrollHelper(driver);
    }
    public void scrollDown(WebElement webElement){
        hideKeyboard();
        int i = 0;
        while (i < 12) {
            if (webElement.isDisplayed()) {
                return;
            }
            down();
            i++;
        }
    }

    public void scrollUp(WebElement webElement) {
        hideKeyboard();
        int i = 0;
        while (i < 12) {
            if (webElement.isDisplayed()) {
                return;
            }
            up();
            i++;
        }
    }

    public void down() {
        driver.swipe(5, getHeight() * 2 / 3, 5, getHeight() / 3, 1000);
    }

    public void up() {
        driver.swipe(5, getHeight() / 3, 5, getHeight() * 2 / 3, 1000);
    }

}
