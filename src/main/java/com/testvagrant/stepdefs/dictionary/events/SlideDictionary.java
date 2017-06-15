package com.testvagrant.stepdefs.dictionary.events;

import com.testvagrant.stepdefs.actions.Slide;
import com.testvagrant.stepdefs.core.events.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlideDictionary extends EventDictionary {


    private List<String> slideDictionary = new ArrayList<>();
    private Map<Event,List<String>> slideMap = new HashMap<>();

    private SlideDictionary() {

    }

    public static SlideDictionary slideDictionary() {
        return new SlideDictionary();
    }

    public SlideDictionary open() {
        initSlideDictionary();
        slideMap.put(Slide.SLIDE,slideDictionary);
        return this;
    }

    public Event search(String action) {
       return search(slideMap,action);
    }

    private void initSlideDictionary() {
        slideDictionary.add("slides");
        slideDictionary.add("slide");
    }

}
