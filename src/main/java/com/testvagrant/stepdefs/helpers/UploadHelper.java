package com.testvagrant.stepdefs.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadHelper extends ActionHelper {

    private WebDriver driver;
    private WebElement element;
    private String value;

    private UploadHelper(WebDriver driver) {
        super(driver);
    }

    public static UploadHelper uploadHelper(WebDriver driver) {
        return new UploadHelper(driver);
    }

    public UploadHelper onElement(WebElement element) {
        this.element = element;
        return this;
    }

    public void selectFilePathWith(String value) {
        element.sendKeys(value);
    }
}
