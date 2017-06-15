package com.testvagrant.stepdefs.helpers;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class TypeHelper extends ActionHelper {

    private AppiumDriver driver;
    private WebElement element;
    private String value;
    private TypeHelper(AppiumDriver driver) {
        super(driver);
    }

    public static TypeHelper typeHelper(AppiumDriver driver) {
        return new TypeHelper(driver);
    }

    public TypeHelper onElement(WebElement element) {
        this.element= element;
        return this;
    }

    public void type(String value) {
        waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(value);
    }
}
