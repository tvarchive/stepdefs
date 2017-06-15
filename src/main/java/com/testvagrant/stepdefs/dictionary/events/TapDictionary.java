package com.testvagrant.stepdefs.dictionary.events;


import com.testvagrant.stepdefs.actions.Tap;
import com.testvagrant.stepdefs.core.events.Event;

import java.util.*;

public class TapDictionary extends EventDictionary {

    private List<String> singleTapDictionary = new ArrayList<>();
    private List<String> doubleTapDictionary = new ArrayList<>();
    private Map<Event,List<String>> tapMap = new HashMap<>();

    private TapDictionary() {

    }

    public static TapDictionary tapDictionary() {
        return new TapDictionary();
    }

    public TapDictionary open() {
        initSingleTapDictionary();
        initDoubleTapDictionary();
        tapMap.put(Tap.TAP,singleTapDictionary);
        tapMap.put(Tap.DOUBLETAP,doubleTapDictionary);
        return this;
    }

    public Event search(String action) {
        return search(tapMap,action);
    }


    private void initSingleTapDictionary(){
        singleTapDictionary.add("tap");
        singleTapDictionary.add("taps");
    }

    private void initDoubleTapDictionary(){
        doubleTapDictionary.add("double tap");
        doubleTapDictionary.add("double taps");
        doubleTapDictionary.add("doubletap");
        doubleTapDictionary.add("doubletaps");
    }
}
