package com.testvagrant.stepdefs.core;


import com.testvagrant.stepdefs.core.events.Event;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import static com.testvagrant.stepdefs.core.events.EventCodes.*;
import static com.testvagrant.stepdefs.core.events.EventLookup.eventLookup;
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

    void serve() {
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
                scroller(driver).scrollUp(element);
                break;
            case SCROLL_DOWN_CODE:
                scroller(driver).scrollDown(element);
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


    private int getEventValue(String event) {
        return Integer.valueOf(event,2);
    }


}
