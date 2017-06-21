package com.testvagrant.stepdefs.core.events;


import com.testvagrant.stepdefs.dictionary.events.EventDictionary;
import com.testvagrant.stepdefs.exceptions.NoSuchEventException;

import java.util.ArrayList;
import java.util.List;

import static com.testvagrant.stepdefs.dictionary.events.AssertDictionary.assertDictionary;
import static com.testvagrant.stepdefs.dictionary.events.ScrollDictionary.scrollDictionary;
import static com.testvagrant.stepdefs.dictionary.events.SlideDictionary.slideDictionary;
import static com.testvagrant.stepdefs.dictionary.events.SwipeDictionary.swipeDictionary;
import static com.testvagrant.stepdefs.dictionary.events.TapDictionary.tapDictionary;
import static com.testvagrant.stepdefs.dictionary.events.TypeDictionary.typeDictionary;

public class EventFinder {

    private Event event;
    private List<EventDictionary> eventDictionaries;

    private EventFinder() {
        eventDictionaries = new ArrayList<>();
        eventDictionaries.add(scrollDictionary());
        eventDictionaries.add(swipeDictionary());
        eventDictionaries.add(slideDictionary());
        eventDictionaries.add(tapDictionary());
        eventDictionaries.add(typeDictionary());
        eventDictionaries.add(assertDictionary());
    }

    public static EventFinder eventFinder() {
        return new EventFinder();
    }

    public Event findEvent(String action) throws NoSuchEventException {
        if(event==null && eventDictionaries.size()>0) {
            event = eventDictionaries.get(0).open().search(action);
            if(event==null) {
                eventDictionaries.remove(0);
                findEvent(action);
            }else  {
                return event;
            }
        }
        if(event ==null)
            throw new NoSuchEventException(action);
        else
            return event;
    }
}
