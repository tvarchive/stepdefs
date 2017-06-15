package com.testvagrant.stepdefs.helpers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebElement;

public class SlideHelper extends ActionHelper {

    private WebElement element;
    private final int offset = 200;
    private SlideHelper(AppiumDriver driver) {
        super(driver);
    }


    public static SlideHelper slider(AppiumDriver driver) {
        return new SlideHelper(driver);
    }


    public SlideHelper on(WebElement element) {
        this.element = element;
        return this;
    }

    public void slide(String percentage) {
        int xStartingPoint = element.getLocation().getX();
        int xEndingPoint = element.getSize().getWidth();
        int yStartingAndEndingPoint = element.getLocation().getY();
        moveSliderAccordingToSpecifiedPercentage(xStartingPoint,xEndingPoint,yStartingAndEndingPoint,getInt(percentage));
    }

    private void moveSliderAccordingToSpecifiedPercentage(int xStartingPoint, int xEndingPoint, int yStartingAndEndingPoint, int slideByPercentage) {
        double slideFactor = (double)slideByPercentage/(double)100;
        int pointToMoveTo = (int) ((xEndingPoint+offset)*slideFactor);
        touchAction = new TouchAction(driver);
        waitForElementToBeClickable(element);
        touchAction.longPress(element,xStartingPoint,yStartingAndEndingPoint,1000).moveTo(pointToMoveTo,yStartingAndEndingPoint).release().perform();
    }


}
