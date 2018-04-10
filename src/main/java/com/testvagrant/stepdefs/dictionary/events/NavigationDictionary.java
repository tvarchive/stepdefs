package com.testvagrant.stepdefs.dictionary.events;

import com.testvagrant.stepdefs.actions.Navigation;
import com.testvagrant.stepdefs.core.events.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NavigationDictionary extends EventDictionary {

    private List<String> navigateBackDictionary = new ArrayList<>();
    private List<String> navigateForwardDictionary = new ArrayList<>();
    private List<String> refreshDictionary = new ArrayList<>();
    private List<String> hideKeyBoardDictionary = new ArrayList<>();

    private Map<Event, List<String>> navigationMap = new HashMap<>();

    public NavigationDictionary() {
    }

    public static NavigationDictionary navigationDictionary() {
        return new NavigationDictionary();
    }

    public NavigationDictionary open() {
        initNavigationBackDictionary();
        initNavigationForwardDictionary();
        initRefreshDictionary();
        initHideKeyboardDictionary();
        navigationMap.put(Navigation.NAVIGATE_BACK, navigateBackDictionary);
        navigationMap.put(Navigation.NAVIGATE_FORWARD, navigateForwardDictionary);
        navigationMap.put(Navigation.REFRESH, refreshDictionary);
        navigationMap.put(Navigation.HIDE_KEYBOARD, hideKeyBoardDictionary);
        return this;
    }

    public Event search(String action) {
        return search(navigationMap, action);
    }

    private void initNavigationBackDictionary() {
        navigateBackDictionary.add("navigates back");
        navigateBackDictionary.add("navigates-back");
        navigateBackDictionary.add("navigate back");
        navigateBackDictionary.add("navigate-back");
        navigateBackDictionary.add("navigates to back");
        navigateBackDictionary.add("navigates-to-back");
        navigateBackDictionary.add("navigate to back");
        navigateBackDictionary.add("navigate-to-back");
        navigateBackDictionary.add("clicks on back");
        navigateBackDictionary.add("clicks-on-back");
        navigateBackDictionary.add("clicks on back button");
        navigateBackDictionary.add("clicks-on-back-button");
        navigateBackDictionary.add("click on back");
        navigateBackDictionary.add("click-on-back");
        navigateBackDictionary.add("click on back button");
        navigateBackDictionary.add("click-on-back-button");
        navigateBackDictionary.add("move to back");
        navigateBackDictionary.add("move-to-back");
        navigateBackDictionary.add("moves to back");
        navigateBackDictionary.add("moves-to-back");
        navigateBackDictionary.add("go to back");
        navigateBackDictionary.add("go-to-back");
        navigateBackDictionary.add("goes to back");
        navigateBackDictionary.add("goes-to-back");
    }

    private void initNavigationForwardDictionary() {
        navigateForwardDictionary.add("navigates forward");
        navigateForwardDictionary.add("navigates-forward");
        navigateForwardDictionary.add("navigate forward");
        navigateForwardDictionary.add("navigate-forward");
        navigateForwardDictionary.add("navigates to forward");
        navigateForwardDictionary.add("navigates-to-forward");
        navigateForwardDictionary.add("navigate to forward");
        navigateForwardDictionary.add("navigate-to-forward");
        navigateForwardDictionary.add("clicks on forward");
        navigateForwardDictionary.add("clicks-on-forward");
        navigateForwardDictionary.add("clicks on back forward");
        navigateForwardDictionary.add("clicks-on-back-forward");
        navigateForwardDictionary.add("click on forward");
        navigateForwardDictionary.add("click-on-forward");
        navigateForwardDictionary.add("click on back forward");
        navigateForwardDictionary.add("click-on-back-button");
        navigateForwardDictionary.add("move to forward");
        navigateForwardDictionary.add("move-to-forward");
        navigateForwardDictionary.add("moves to forward");
        navigateForwardDictionary.add("moves-to-forward");
        navigateForwardDictionary.add("go to forward");
        navigateForwardDictionary.add("go-to-forward");
        navigateForwardDictionary.add("goes to forward");
        navigateForwardDictionary.add("goes-to-forward");
    }

    private void initRefreshDictionary() {
        refreshDictionary.add("refresh");
        refreshDictionary.add("refresh's");
        refreshDictionary.add("refreshs");
        refreshDictionary.add("refresh screen");
        refreshDictionary.add("refresh-screen");
        refreshDictionary.add("refresh the screen");
        refreshDictionary.add("refresh-the-screen");
        refreshDictionary.add("refresh's the screen");
        refreshDictionary.add("refresh's-the-screen");
    }

    private void initHideKeyboardDictionary() {
        hideKeyBoardDictionary.add("hide keyboard");
        hideKeyBoardDictionary.add("hide-keyboard");
        hideKeyBoardDictionary.add("hides keyboard");
        hideKeyBoardDictionary.add("hides-keyboard");
        hideKeyBoardDictionary.add("hide's keyboard");
        hideKeyBoardDictionary.add("hide's-keyboard");
    }

}
