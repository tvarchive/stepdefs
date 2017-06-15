package com.testvagrant.stepdefs.dictionary.events;


import com.testvagrant.stepdefs.core.events.Event;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.testvagrant.stepdefs.predicates.ActionPredicate.isActionPresent;

public abstract class EventDictionary {

    public abstract EventDictionary open();

    public abstract Event search(String action);

    protected Event search(Map<Event,List<String>> actionsMap, String action) {
        Optional<Map.Entry<Event, List<String>>> first = actionsMap.entrySet().stream().filter(isActionPresent(action)).findFirst();
        if(first.isPresent()) {
            return first.get().getKey();
        }
        return null;
    }
}
