package com.testvagrant.stepdefs.core;


import com.testvagrant.stepdefs.actions.Tap;
import com.testvagrant.stepdefs.core.events.Event;
import com.testvagrant.stepdefs.exceptions.NoSuchEventException;
import org.junit.Assert;
import org.junit.Test;

import static com.testvagrant.stepdefs.core.events.EventFinder.eventFinder;

public class EventFinderTest {

    @Test
    public void findAnEvent() throws NoSuchEventException {
        Event event = eventFinder().findEvent("taps");
        Assert.assertEquals(Tap.TAP,event);
        Event event1 = eventFinder().findEvent("doubletap");
        Assert.assertEquals(Tap.DOUBLETAP,event1);
    }
}
