package com.testvagrant.stepdefs.helpers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TypeHelper extends ActionHelper {

    private WebDriver driver;
    private WebElement element;
    private String value;
    private TypeHelper(WebDriver driver) {
        super(driver);
    }

    public static TypeHelper typeHelper(WebDriver driver) {
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
