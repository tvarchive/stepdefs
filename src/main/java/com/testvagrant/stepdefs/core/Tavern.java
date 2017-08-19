package com.testvagrant.stepdefs.core;

import com.testvagrant.stepdefs.core.events.Event;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.testvagrant.stepdefs.core.events.EventCodes.*;
import static com.testvagrant.stepdefs.core.events.EventLookup.eventLookup;
import static com.testvagrant.stepdefs.helpers.AssertHelper.assertHelper;
import static com.testvagrant.stepdefs.helpers.ClickHelper.clickHelper;
import static com.testvagrant.stepdefs.helpers.SelectHelper.selectHelper;
import static com.testvagrant.stepdefs.helpers.TypeHelper.typeHelper;
import static com.testvagrant.stepdefs.helpers.UploadHelper.uploadHelper;

public class Tavern {

    private Event event;
    private WebElement element;
    private String value;
    private WebDriver driver;
    private By by;

    private Tavern(WebDriver driver) {
        this.driver = driver;
    }

    public static Tavern tavern(WebDriver driver) {
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
            case TYPE:
                serveType();
                break;
            case CLICK:
                serveClick();
                break;
            case SELECT:
                serveSelect();
                break;
            case UPLOAD:
                serveUpload();
                break;
            case ASSERT:
                serveAssert();
                break;
        }
    }

    void serve(By targetBy) {
        this.by = targetBy;
        int eventValue = getEventValue(event.getEventCode());
        switch (eventLookup().load().getEvent(eventValue)) {
            case ASSERT:
                serveAssert();
                break;
            case SELECT:
                serveSelect();
                break;
            case UPLOAD:
                serveUpload();
                break;
        }
    }

    private void serveUpload() {
        switch (event.getEventCode()) {
            case UPLOAD_CODE:
                uploadHelper(driver).onElement(element).selectFilePathWith(value);
                break;
        }
    }

    private void serveClick() {
        switch (event.getEventCode()) {
            case CLICK_CODE:
                clickHelper(driver).click(element);
                break;
            case DOUBLE_CLICK_CODE:
                clickHelper(driver).doubleClick(element);
                break;
        }
    }

    private void serveSelect() {
        switch (event.getEventCode()) {
            case SELECT_DROPDOWN_TEXT_CODE:
                selectHelper(driver).onElement(element).selectText(value);
                break;
        }
    }

    private void serveAssert() {
        switch (event.getEventCode()) {
            case ASSERT_IS_VISIBLE_CODE:
                assertHelper(driver).isTextDisplayed(element, value);
                break;
            case ASSERT_IS_NOT_VISIBLE_CODE:
                assertHelper(driver).isTextNotDisplayed(element, value);
                break;
            case ASSERT_IS_ENABLED_CODE:
                assertHelper(driver).isEnabled(element);
                break;
            case ASSERT_IS_NOT_ENABLED_CODE:
                assertHelper(driver).isNotEnabled(by);
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
        return Integer.valueOf(event, 2);
    }
}
