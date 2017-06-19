package com.testvagrant.stepdefs.core;


import com.testvagrant.commons.exceptions.OptimusException;
import com.testvagrant.stepdefs.core.events.Event;
import com.testvagrant.stepdefs.core.events.Events;
import com.testvagrant.stepdefs.exceptions.NoSuchEventException;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import static com.testvagrant.stepdefs.core.Tavern.tavern;
import static com.testvagrant.stepdefs.core.events.EventFinder.eventFinder;
import static com.testvagrant.stepdefs.core.events.EventLookup.eventLookup;
import static com.testvagrant.stepdefs.core.events.Events.ASSERT;
import static com.testvagrant.stepdefs.finder.OptimusElementFinder.optimusElementFinder;

public class Tapster {

    private AppiumDriver driver;
    private String consumer;
    private String screen;
    private String action;
    private String element;
    private String value;

    private Tapster() {

    }

    public Tapster useDriver(AppiumDriver driver) {
        this.driver = driver;
        return this;
    }

    public Tapster asConsumer(String consumer) {
        this.consumer = consumer;
        return this;
    }

    public Tapster onScreen(String screen) {
        this.screen = StringUtils.capitalize(screen);
//        this.screen = screen;
        return this;
    }

    public Tapster doAction(String action) {
        this.action = action;
        return this;
    }

    public Tapster onElement(String element) {
        this.element = element;
        return this;
    }

    public Tapster withValue(String value) {
        this.value = value;
        return this;
    }

    public static Tapster tapster() {
        return new Tapster();
    }


    public Tapster serve() throws NoSuchEventException, OptimusException {
        Event event = eventFinder().findEvent(action);
        By targetBy = optimusElementFinder(driver).find(consumer, screen, element);
        Events events = eventLookup().load().getEvent(Integer.valueOf(event.getEventCode(), 2));
        if (ASSERT.equals(events))
            tavern(driver).event(event).value(value).serve(targetBy);
        else
            tavern(driver).event(event).value(value).serve(driver.findElement(targetBy));
        return this;
    }


}
