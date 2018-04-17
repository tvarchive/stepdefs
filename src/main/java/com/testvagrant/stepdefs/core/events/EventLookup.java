package com.testvagrant.stepdefs.core.events;

import java.util.HashMap;
import java.util.Map;

public class EventLookup {

    private Map<Integer, Events> eventsMap = new HashMap<>();

    private EventLookup() {
    }

    public static EventLookup eventLookup() {
        return new EventLookup();
    }

    public EventLookup load() {
        initEventMap();
        return this;
    }

    public Events getEvent(int eventCode) {
        return eventsMap.get(eventCode);
    }

    private void initEventMap() {
        eventsMap.put(1, Events.TAP);
        eventsMap.put(2, Events.TAP);
        eventsMap.put(3, Events.SCROLL);
        eventsMap.put(4, Events.SCROLL);
        eventsMap.put(5, Events.SWIPE);
        eventsMap.put(6, Events.SWIPE);
        eventsMap.put(7, Events.SLIDE);
        eventsMap.put(8, Events.TYPE);
        eventsMap.put(9, Events.ASSERT);
        eventsMap.put(10, Events.ASSERT);
        eventsMap.put(11, Events.ASSERT);
        eventsMap.put(12, Events.ASSERT);
        eventsMap.put(13, Events.ASSERT);
        eventsMap.put(14, Events.ASSERT);
        eventsMap.put(15, Events.SCROLL);
        eventsMap.put(16, Events.SCROLL);
        eventsMap.put(17, Events.SCROLL);
        eventsMap.put(18, Events.SCROLL);
        eventsMap.put(19, Events.NAVIGATION);
        eventsMap.put(20, Events.NAVIGATION);
        eventsMap.put(21, Events.NAVIGATION);
        eventsMap.put(22, Events.NAVIGATION);
    }
}
