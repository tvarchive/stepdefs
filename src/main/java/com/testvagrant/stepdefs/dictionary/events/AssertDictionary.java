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
        assertIsNotVisibleDictionary.add("NotVisible");
        assertIsNotVisibleDictionary.add("Not-Visible");
        assertIsNotVisibleDictionary.add("Not Visible");
        assertIsNotVisibleDictionary.add("Not Displayed");
    }

    private void initAssertIsVisibleDictionary() {
        assertIsVisibleDictionary.add("Visible");
        assertIsVisibleDictionary.add("Displayed");
    }

    private void initAssertIsNotEnabledDictionary() {
        assertIsNotEnabledDictionary.add("Disabled");
        assertIsNotEnabledDictionary.add("Not Enabled");
    }

    private void initAssertIsEnabledDictionary() {
        assertIsEnabledDictionary.add("Enabled");
    }

    private void initAssertIsTextNotPresentDictionary() {
        assertIsTextNotPresentDictionary.add("TextNotPresent");
        assertIsTextNotPresentDictionary.add("Text-Not-Present");
        assertIsTextNotPresentDictionary.add("Text Not Present");
        assertIsTextNotPresentDictionary.add(("Text Not Displayed"));
    }

    private void initAssertIsTextPresentDictionary() {
        assertIsTextPresentDictionary.add("TextPresent");
        assertIsTextPresentDictionary.add("Text-Present");
        assertIsTextPresentDictionary.add("Text Present");
        assertIsTextPresentDictionary.add(("Text Displayed"));
    }

    public Event search(String action) {
        return search(assertMap, action);
    }

}
