package com.testvagrant.stepdefs.dictionary.events;


import com.testvagrant.stepdefs.actions.Scroll;
import com.testvagrant.stepdefs.core.events.Event;

import java.util.*;

public class ScrollDictionary extends EventDictionary {

    private List<String> scrollUpDictionary = new ArrayList<>();
    private List<String> scrollDownDictionary = new ArrayList<>();
    private List<String> scrollUpInElementDictionary = new ArrayList<>();
    private List<String> scrollDownInElementDictionary = new ArrayList<>();
    private List<String> scrollLeftInElementDictionary = new ArrayList<>();
    private List<String> scrollRightInElementDictionary = new ArrayList<>();
    private Map<Event,List<String>> scrollMap = new HashMap<>();

    private ScrollDictionary() {

    }
    public static ScrollDictionary scrollDictionary() {
        return new ScrollDictionary();
    }

    public ScrollDictionary open() {
        return new ScrollDictionary().init();
    }

    public Event search(String action) {
        return search(scrollMap,action);
    }

    private ScrollDictionary init() {
        initScrollUpDictionary();
        initScrollDownDictionary();
        initScrollUpInElementDictionary();
        initScrollDownInElementDictionary();
        initScrollLeftInElementDictionary();
        initScrollRightInElementDictionary();
        scrollMap.put(Scroll.SCROLL_UP,scrollUpDictionary);
        scrollMap.put(Scroll.SCROLL_DOWN,scrollDownDictionary);
        scrollMap.put(Scroll.SCROLL_UP_TO_ELEMENT,scrollUpInElementDictionary);
        scrollMap.put(Scroll.SCROLL_DOWN_TO_ELEMENT,scrollDownInElementDictionary);
        scrollMap.put(Scroll.SCROLL_LEFT_TO_ELEMENT,scrollLeftInElementDictionary);
        scrollMap.put(Scroll.SCROLL_RIGHT_TO_ELEMENT,scrollRightInElementDictionary);
        return this;
    }

    private void initScrollRightInElementDictionary() {
        scrollRightInElementDictionary.add("scrollrightinelement");
    }

    private void initScrollLeftInElementDictionary() {
        scrollLeftInElementDictionary.add("scrollleftinelement");
    }

    private void initScrollDownInElementDictionary() {
        scrollDownInElementDictionary.add("scrolldowninelement");
    }

    private void initScrollUpInElementDictionary() {
        scrollUpInElementDictionary.add("scrollupinelement");
    }

    private void initScrollUpDictionary() {
        scrollUpDictionary.add("scrolls up");
        scrollUpDictionary.add("scroll up");
        scrollUpDictionary.add("scrollup");
        scrollUpDictionary.add("scrolls-up");
        scrollUpDictionary.add("scroll-up");
    }

    private void initScrollDownDictionary() {
        scrollDownDictionary.add("scrolls down");
        scrollDownDictionary.add("scroll down");
        scrollDownDictionary.add("scrolldown");
        scrollDownDictionary.add("scrollsdown");
        scrollDownDictionary.add("scrolls-down");
        scrollDownDictionary.add("scroll-down");
    }

}
