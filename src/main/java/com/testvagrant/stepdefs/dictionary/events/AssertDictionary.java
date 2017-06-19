package com.testvagrant.stepdefs.dictionary.events;

import com.testvagrant.stepdefs.actions.Assert;
import com.testvagrant.stepdefs.core.events.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by abhishek on 16/06/17.
 */
public class AssertDictionary extends EventDictionary {
    private List<String> assertIsVisibleDictionary = new ArrayList<>();
    private List<String> assertIsNotVisibleDictionary = new ArrayList<>();
    private List<String> assertIsTextPresentDictionary = new ArrayList<>();
    private List<String> assertIsTextNotPresentDictionary = new ArrayList<>();
    private List<String> assertIsEnabledDictionary = new ArrayList<>();
    private List<String> assertIsNotEnabledDictionary = new ArrayList<>();
    private Map<Event, List<String>> assertMap = new HashMap<>();

    public AssertDictionary() {
    }

    public static AssertDictionary assertDictionary() {
        return new AssertDictionary();
    }

    public AssertDictionary open() {
        initAssertIsTextPresentDictionary();
        initAssertIsTextNotPresentDictionary();
        initAssertIsEnabledDictionary();
        initAssertIsNotEnabledDictionary();
        initAssertIsVisibleDictionary();
        initAssertIsNotVisibleDictionary();
        assertMap.put(Assert.ASSERT_IS_TEXT_DISPLAYED, assertIsTextPresentDictionary);
        assertMap.put(Assert.ASSERT_IS_TEXT_NOT_DISPLAYED, assertIsTextNotPresentDictionary);
        assertMap.put(Assert.ASSERT_IS_ENABLED, assertIsEnabledDictionary);
        assertMap.put(Assert.ASSERT_IS_NOT_ENABLED, assertIsNotEnabledDictionary);
        assertMap.put(Assert.ASSERT_IS_VISIBLE, assertIsVisibleDictionary);
        assertMap.put(Assert.ASSERT_IS_NOT_VISIBLE, assertIsNotVisibleDictionary);
        return this;
    }

    private void initAssertIsNotVisibleDictionary() {
        assertIsVisibleDictionary.add("IsNotVisible");
        assertIsVisibleDictionary.add("Is-Not-Visible");
        assertIsVisibleDictionary.add("Is Not Visible");
        assertIsVisibleDictionary.add("Is Not Displayed");
    }

    private void initAssertIsVisibleDictionary() {
        assertIsVisibleDictionary.add("IsVisible");
        assertIsVisibleDictionary.add("Is-Visible");
        assertIsVisibleDictionary.add("Is Visible");
        assertIsVisibleDictionary.add("Is Displayed");
    }

    private void initAssertIsNotEnabledDictionary() {
        assertIsNotEnabledDictionary.add("IsDisabled");
        assertIsNotEnabledDictionary.add("Is-Disabled");
        assertIsNotEnabledDictionary.add("Is Disabled");
        assertIsNotEnabledDictionary.add("Is Not Displayed");
    }

    private void initAssertIsEnabledDictionary() {
        assertIsEnabledDictionary.add("IsEnabled");
        assertIsEnabledDictionary.add("Is-Enabled");
        assertIsEnabledDictionary.add("Is Enabled");
        assertIsEnabledDictionary.add("Is Displayed");
    }

    private void initAssertIsTextNotPresentDictionary() {
        assertIsTextNotPresentDictionary.add("IsTextNotPresent");
        assertIsTextNotPresentDictionary.add("Is-Text-Not-Present");
        assertIsTextNotPresentDictionary.add("Is Text Not Present");
        assertIsTextNotPresentDictionary.add(("Is Text Not Displayed"));
    }

    private void initAssertIsTextPresentDictionary() {
        assertIsTextPresentDictionary.add("IsTextPresent");
        assertIsTextPresentDictionary.add("Is-Text-Present");
        assertIsTextPresentDictionary.add("Is Text Present");
        assertIsTextPresentDictionary.add(("Is Text Displayed"));
    }

    public Event search(String action) {
        return search(assertMap, action);
    }

}
