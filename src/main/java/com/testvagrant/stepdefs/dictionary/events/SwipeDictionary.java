package com.testvagrant.stepdefs.dictionary.events;


import com.testvagrant.stepdefs.actions.Swipe;
import com.testvagrant.stepdefs.core.events.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwipeDictionary extends EventDictionary {

    private List<String> swipeLeftDictionary = new ArrayList<>();
    private List<String> swipeRightDictionary = new ArrayList<>();
    private Map<Event,List<String>> swipeMap = new HashMap<>();

    private SwipeDictionary() {

    }

    public static SwipeDictionary swipeDictionary() {
        return new SwipeDictionary();
    }

    public SwipeDictionary open() {
        initSwipeLeftDictionary();
        initSwipeRightDictionary();
        swipeMap.put(Swipe.SWIPE_LEFT,swipeLeftDictionary);
        swipeMap.put(Swipe.SWIPE_RIGHT,swipeRightDictionary);
        return this;
    }

    public Event search(String action) {
        return search(swipeMap,action);
    }

    private void initSwipeLeftDictionary() {
        swipeLeftDictionary.add("swipe left");
        swipeLeftDictionary.add("swipeleft");
        swipeLeftDictionary.add("swipe-left");
        swipeLeftDictionary.add("swipes left");
        swipeLeftDictionary.add("swipesleft");
        swipeLeftDictionary.add("swipes-left");
    }

    private void initSwipeRightDictionary() {
        swipeRightDictionary.add("swipe right");
        swipeRightDictionary.add("swipe-right");
        swipeRightDictionary.add("swiperight");
        swipeRightDictionary.add("swipes right");
        swipeRightDictionary.add("swipes-right");
        swipeRightDictionary.add("swipesright");
    }

}
