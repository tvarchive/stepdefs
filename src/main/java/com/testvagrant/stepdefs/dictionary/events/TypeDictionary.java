package com.testvagrant.stepdefs.dictionary.events;


import com.testvagrant.stepdefs.actions.Type;
import com.testvagrant.stepdefs.core.events.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeDictionary extends EventDictionary{


    private List<String> typeDictionary = new ArrayList<>();
    private Map<Event,List<String>> typeMap = new HashMap<>();
    private TypeDictionary() {

    }

    public static TypeDictionary typeDictionary() {
        return new TypeDictionary();
    }

    @Override
    public EventDictionary open() {
        initTypeDictionary();
        typeMap.put(Type.TYPE,typeDictionary);
        return this;
    }

    @Override
    public Event search(String action) {
        return search(typeMap,action);
    }

    private void initTypeDictionary() {
        typeDictionary.add("types");
        typeDictionary.add("type");
    }
}
