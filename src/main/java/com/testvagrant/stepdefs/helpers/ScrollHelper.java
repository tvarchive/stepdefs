package com.testvagrant.stepdefs.helpers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;


public class ScrollHelper extends ActionHelper {

    protected ScrollHelper(AppiumDriver driver) {
        super(driver);
    }

    public static ScrollHelper scroller(AppiumDriver driver) {
        return new ScrollHelper(driver);
    }

    public void scrollDown(By by) {
        hideKeyboard();
        int i = 0;
        while (i < 12) {
            if (isElementPresent(by)) {
                return;
            }
            down();
            i++;
        }
    }

    public void scrollUp(By by) {
        hideKeyboard();
        int i = 0;
        while (i < 12) {
            if (isElementPresent(by)) {
                return;
            }
            up();
            i++;
        }
    }

    public void scrollUpInElement(By inElement, String toText) {
        hideKeyboard();
        WebElement element = inElement.findElement(driver);
        Dimension dimension = element.getSize();
        Point point = element.getLocation();

        Point start = new Point(point.getX() + dimension.getHeight() * 2 / 3
                , point.getY() + dimension.getWidth() / 2);
        Point end = new Point(point.getX() + dimension.getHeight() / 3
                , point.getY() + dimension.getWidth() / 2);

        int i = 0;
        while (i < 12) {
            if (isTextPresent(inElement, toText)) {
                return;
            }
            swipe(start.x, start.y, end.x, end.y);
            i++;
        }
    }

    public void scrollDownInElement(By inElement, String toText) {
        hideKeyboard();
        WebElement element = inElement.findElement(driver);
        Dimension dimension = element.getSize();
        Point point = element.getLocation();

        Point start = new Point(point.getX() + dimension.getHeight() / 3
                , point.getY() + dimension.getWidth() / 2);
        Point end = new Point(point.getX() + dimension.getHeight() * 2 / 3
                , point.getY() + dimension.getWidth() / 2);

        int i = 0;
        while (i < 12) {
            if (isTextPresent(inElement, toText)) {
                return;
            }
            swipe(start.x, start.y, end.x, end.y);
            i++;
        }
    }

    public void scrollRightInElement(By inElement, String toText) {
        hideKeyboard();
        WebElement element = inElement.findElement(driver);
        Dimension dimension = element.getSize();
        Point point = element.getLocation();

        Point start = new Point(point.getX() + dimension.getHeight() / 2
                , point.getY() + dimension.getWidth() * 2 / 3);
        Point end = new Point(point.getX() + dimension.getHeight() / 2
                , point.getY() + dimension.getWidth() / 3);

        int i = 0;
        while (i < 12) {
            if (isTextPresent(inElement, toText)) {
                return;
            }
            swipe(start.x, start.y, end.x, end.y);
            i++;
        }
    }

    public void scrollLeftinElement(By inElement, String toText) {
        hideKeyboard();
        WebElement element = inElement.findElement(driver);
        Dimension dimension = element.getSize();
        Point point = element.getLocation();

        Point start = new Point(point.getX() + dimension.getHeight() / 2
                , point.getY() + dimension.getWidth() / 3);
        Point end = new Point(point.getX() + dimension.getHeight() / 2
                , point.getY() + dimension.getWidth() * 2 / 3);

        int i = 0;
        while (i < 12) {
            if (isTextPresent(inElement, toText)) {
                return;
            }
            swipe(start.x, start.y, end.x, end.y);
            i++;
        }
    }

    private void down() {
        driver.swipe(5, getHeight() * 2 / 3, 5, getHeight() / 3, 1000);
    }

    private void up() {
        driver.swipe(5, getHeight() / 3, 5, getHeight() * 2 / 3, 1000);
    }

    private void swipe(int startX, int startY, int endX, int endY) {
        driver.swipe(startX, startY, endX, endY, 1000);
    }

    private boolean isTextPresent(By by, String text) {
        try {
            String xpath = "//*[@text='" + text + "']";
            By.xpath(xpath).findElement(driver.findElement(by));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
