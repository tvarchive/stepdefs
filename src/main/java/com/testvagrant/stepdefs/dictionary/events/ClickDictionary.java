package com.testvagrant.stepdefs.dictionary.events;

import com.testvagrant.stepdefs.actions.Click;
import com.testvagrant.stepdefs.core.events.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClickDictionary extends EventDictionary {

    private List<String> doubleClickDictionary = new ArrayList<>();
    private List<String> clickDictionary = new ArrayList<>();

    private Map<Event,List<String>> clickMap = new HashMap<>();

    private ClickDictionary() {

    }
    public static ClickDictionary clickDictionary() {
        return new ClickDictionary();
    }

    public ClickDictionary open() {
        return new ClickDictionary().init();
    }

    public Event search(String action) {
        return search(clickMap,action);
    }

    private ClickDictionary init() {
        initDoubleClickDictionary();
        initClickDictionary();
        clickMap.put(Click.CLICK, clickDictionary);
        clickMap.put(Click.DOUBLE_CLICK, doubleClickDictionary);
        return this;
    }

    private void initDoubleClickDictionary() {
        doubleClickDictionary.add("doubleclick");
        doubleClickDictionary.add("double click");
        doubleClickDictionary.add("double clicks");
        doubleClickDictionary.add("double-click");
        doubleClickDictionary.add("double-clicks");
    }

    private void initClickDictionary() {
        clickDictionary.add("click");
        clickDictionary.add("clicks");
    }
}
