package com.testvagrant.stepdefs.dictionary.events;

import com.testvagrant.stepdefs.actions.Select;
import com.testvagrant.stepdefs.core.events.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectDictionary extends EventDictionary{

    private List<String> selectDictionary;

    private Map<Event,List<String>> selectMap;

    private SelectDictionary() {
        selectDictionary = new ArrayList<>();
        selectMap = new HashMap<>();
    }

    public static SelectDictionary selectDictionary() {
        return new SelectDictionary();
    }

    public SelectDictionary open() {
        return new SelectDictionary().init();
    }

    public Event search(String action) {
        return search(selectMap,action);
    }

    private SelectDictionary init() {
        initSelectDictionary();
        selectMap.put(Select.SELECT_DROPDOWN_TEXT, selectDictionary);
        return this;
    }

    private void initSelectDictionary() {
        selectDictionary.add("select");
        selectDictionary.add("Select");
        selectDictionary.add("selects");
        selectDictionary.add("selectS");
        selectDictionary.add("Selects");
    }
}
