package com.testvagrant.stepdefs.core;

import com.testvagrant.stepdefs.core.events.Event;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.testvagrant.stepdefs.core.events.EventCodes.*;
import static com.testvagrant.stepdefs.core.events.EventLookup.eventLookup;
import static com.testvagrant.stepdefs.helpers.AssertHelper.assertHelper;
import static com.testvagrant.stepdefs.helpers.NavigationHelper.navigator;
import static com.testvagrant.stepdefs.helpers.ScrollHelper.scroller;
import static com.testvagrant.stepdefs.helpers.SlideHelper.slider;
import static com.testvagrant.stepdefs.helpers.SwipeHelper.swiper;
import static com.testvagrant.stepdefs.helpers.TapHelper.tapHelper;
import static com.testvagrant.stepdefs.helpers.TypeHelper.typeHelper;

public class Tavern {

    private Event event;
    private WebElement element;
    private String value;
    private AppiumDriver driver;
    private By by;

    private Tavern(AppiumDriver driver) {
        this.driver = driver;
    }

    public static Tavern tavern(AppiumDriver driver) {
        return new Tavern(driver);
    }

    public Tavern event(Event event) {
        this.event = event;
        return this;
    }

    public Tavern element(WebElement element) {
        this.element = element;
        return this;
    }

    public Tavern value(String value) {
        this.value = value;
        return this;
    }

    void serve(WebElement element) {
        this.element = element;
        int eventValue = getEventValue(event.getEventCode());
        switch (eventLookup().load().getEvent(eventValue)) {
            case TAP:
                serveTaps();
                break;
            case SCROLL:
                serveScroll();
                break;
            case SLIDE:
                serveSlide();
                break;
            case SWIPE:
                serveSwipe();
                break;
            case TYPE:
                serveType();
                break;
        }

    }

    public void serve(By targetBy) {
        this.by = targetBy;
        int eventValue = getEventValue(event.getEventCode());
        switch (eventLookup().load().getEvent(eventValue)) {
            case SCROLL:
                serveScroll();
                break;
            case ASSERT:
                serveAssert();
                break;
        }
    }

    private void serveAssert() {
        switch (event.getEventCode()) {
            case ASSERT_IS_DISPLAYED_CODE:
                assertHelper(driver).isTextDisplayed(by, value);
                break;
            case ASSERT_IS_NOT_DISPLAYED_CODE:
                assertHelper(driver).isTextNotDisplayed(by, value);
                break;
            case ASSERT_IS_ENABLED_CODE:
                assertHelper(driver).isEnabled(by);
                break;
            case ASSERT_IS_NOT_ENABLED_CODE:
                assertHelper(driver).isNotEnabled(by);
                break;
            case ASSERT_IS_VISIBLE_CODE:
                assertHelper(driver).isDisplayed(by);
                break;
            case ASSERT_IS_NOT_VISIBLE_CODE:
                assertHelper(driver).isNotDisplayed(by);
                break;
        }
    }

    private void serveTaps() {
        switch (event.getEventCode()) {
            case TAP_CODE:
                tapHelper(driver).tap(element);
                break;
            case DOUBLE_TAP_CODE:
                tapHelper(driver).doubleTap(element);
                break;
        }
    }

    private void serveScroll() {
        switch (event.getEventCode()) {
            case SCROLL_UP_CODE:
                scroller(driver).scrollUp(by);
                break;
            case SCROLL_DOWN_CODE:
                scroller(driver).scrollDown(by);
                break;
            case SCROLL_UP_IN_ELEMENT_CODE:
                scroller(driver).scrollUpInElement(by, value);
                break;
            case SCROLL_DOWN_IN_ELEMENT_CODE:
                scroller(driver).scrollDownInElement(by, value);
                break;
            case SCROLL_LEFT_IN_ELEMENT_CODE:
                scroller(driver).scrollLeftinElement(by, value);
                break;
            case SCROLL_RIGHT_IN_ELEMENT_CODE:
                scroller(driver).scrollRightInElement(by, value);
                break;
        }
    }

    private void serveSwipe() {
        switch (event.getEventCode()) {
            case SWIPE_LEFT_CODE:
                swiper(driver).swipeLeft(element);
                break;
            case SWIPE_RIGHT_CODE:
                swiper(driver).swipeRight(element);
                break;
        }
    }

    private void serveSlide() {
        switch (event.getEventCode()) {
            case SLIDE_CODE:
                slider(driver).on(element).slide(value);
                break;
        }
    }

    private void serveType() {
        switch (event.getEventCode()) {
            case TYPE_CODE:
                typeHelper(driver).onElement(element).type(value);
                break;
        }
    }

    void serveNavigation() {
        switch (event.getEventCode()) {
            case NAVIGATE_BACK_CODE:
                navigator(driver).navigateBack();
                break;
            case NAVIGATE_FORWARD_CODE:
                navigator(driver).navigateForward();
                break;
            case REFRESH_CODE:
                navigator(driver).refresh();
                break;
            case HIDE_KEYBOARD_CODE:
                navigator(driver).hideKeyBoard();
                break;
        }
    }

    private int getEventValue(String event) {
        return Integer.valueOf(event, 2);
    }

}
