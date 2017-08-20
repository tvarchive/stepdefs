package com.testvagrant.stepdefs.helpers;

import com.testvagrant.stepdefs.finder.WaitControl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by abhishek on 19/06/17.
 */
public class AssertHelper extends ActionHelper {

    AssertHelper(WebDriver driver) {
        super(driver);
    }

    public static AssertHelper assertHelper(WebDriver driver) {
        return new AssertHelper(driver);
    }

    public void isTextDisplayed(WebElement element, String text) {
        waitForElementToBeVisible(element);
        Assert.assertEquals("Text not present ", text, element.getText());
    }

    public void isTextDisplayed(By by, String text) {
        new WaitControl(driver).waitFor("presence", by);
        Assert.assertEquals("Text not present ", text, driver.findElement(by).getText());
    }

    public void isTextNotDisplayed(WebElement element, String text) {
        waitForElementToBeVisible(element);
        Assert.assertNotEquals("Text is present ", text, element.getText());
    }

    public void isTextNotDisplayed(By by, String text) {
        new WaitControl(driver).waitFor("presence",by);
        Assert.assertNotEquals("Text is present ", text, driver.findElement(by).getText());
    }

    public void isEnabled(WebElement element) {
        waitForElementToBeVisible(element);
        Assert.assertEquals("Element not enabled ", true, element.isEnabled());
    }

    public void isEnabled(By by) {
        new WaitControl(driver).waitFor("presence", by);
        Assert.assertEquals("Element not enabled ", true, driver.findElement(by).isEnabled());
    }

    public void isNotEnabled(By by) {
        new WaitControl(driver).waitFor("presence", by);
        Assert.assertEquals("Element is enabled ", false, by.findElement(driver).isEnabled());
    }

    public void isNotEnabled(WebElement element){
        waitForElementToBeVisible(element);
        Assert.assertEquals("Element is enabled ", false, element.isEnabled());
    }

    public void isDisplayed(By by) {
        Assert.assertEquals("Element not visible", true, driver.findElement(by).getText());
    }

    public void isNotDisplayed(By by) {
        Assert.assertEquals("Element is Visible", false, driver.findElement(by).getText());
    }

}
