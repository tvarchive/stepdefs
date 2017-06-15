package com.testvagrant.stepdefs.predicates;


import com.testvagrant.stepdefs.core.events.Event;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class ActionPredicate {

    public static Predicate<Map.Entry<Event,List<String>>> isActionPresent(String action) {
        return entry -> entry.getValue().contains(action);
    }
}
