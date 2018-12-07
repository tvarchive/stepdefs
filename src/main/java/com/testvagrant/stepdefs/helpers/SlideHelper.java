package com.testvagrant.stepdefs.helpers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;

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
        moveSliderAccordingToSpecifiedPercentage(xStartingPoint, xEndingPoint, yStartingAndEndingPoint, getInt(percentage));
    }

    private void moveSliderAccordingToSpecifiedPercentage(int xStartingPoint, int xEndingPoint, int yStartingAndEndingPoint, int slideByPercentage) {
        double slideFactor = (double) slideByPercentage / (double) 100;
        int pointToMoveTo = (int) ((xEndingPoint + offset) * slideFactor);
        waitForElementToBeClickable(element);
        new TouchAction(driver).longPress(longPressOptions()
                .withPosition(point(xStartingPoint, yStartingAndEndingPoint))
                .withElement(element(element)).withDuration(Duration.ofMillis(1000)))
                .moveTo(point(pointToMoveTo, yStartingAndEndingPoint))
                .release().perform();
    }


}
