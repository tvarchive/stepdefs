package com.testvagrant.stepdefs.predicates;

import com.testvagrant.stepdefs.entities.Elements;

import java.util.function.Predicate;


public class ScenarioPredicate {

    public static Predicate<Elements> findMatchingScenario(String intentId) {
        return elements -> elements.getName().trim().equalsIgnoreCase(intentId);
    }
}
