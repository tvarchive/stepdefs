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
    private List<String> assetIsTextNullDictionary = new ArrayList<>();
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
        initAssertIsTextNullDictionary();
        assertMap.put(Assert.ASSERT_IS_TEXT_DISPLAYED, assertIsTextPresentDictionary);
        assertMap.put(Assert.ASSERT_IS_TEXT_NOT_DISPLAYED, assertIsTextNotPresentDictionary);
        assertMap.put(Assert.ASSERT_IS_ENABLED, assertIsEnabledDictionary);
        assertMap.put(Assert.ASSERT_IS_NOT_ENABLED, assertIsNotEnabledDictionary);
        assertMap.put(Assert.ASSERT_IS_VISIBLE, assertIsVisibleDictionary);
        assertMap.put(Assert.ASSERT_IS_NOT_VISIBLE, assertIsNotVisibleDictionary);
        assertMap.put(Assert.ASSERT_IS_TEXT_NULL, assetIsTextNullDictionary);
        return this;
    }

    private void initAssertIsNotVisibleDictionary() {
        assertIsNotVisibleDictionary.add("notvisible");
        assertIsNotVisibleDictionary.add("not-visible");
        assertIsNotVisibleDictionary.add("not visible");
        assertIsNotVisibleDictionary.add("not displayed");
    }

    private void initAssertIsVisibleDictionary() {
        assertIsVisibleDictionary.add("visible");
        assertIsVisibleDictionary.add("displayed");
    }

    private void initAssertIsNotEnabledDictionary() {
        assertIsNotEnabledDictionary.add("disabled");
        assertIsNotEnabledDictionary.add("not enabled");
    }

    private void initAssertIsEnabledDictionary() {
        assertIsEnabledDictionary.add("enabled");
    }

    private void initAssertIsTextNotPresentDictionary() {
        assertIsTextNotPresentDictionary.add("textnotpresent");
        assertIsTextNotPresentDictionary.add("text-not-present");
        assertIsTextNotPresentDictionary.add("text not present");
        assertIsTextNotPresentDictionary.add(("text not displayed"));
    }

    private void initAssertIsTextPresentDictionary() {
        assertIsTextPresentDictionary.add("textpresent");
        assertIsTextPresentDictionary.add("text-present");
        assertIsTextPresentDictionary.add("text present");
        assertIsTextPresentDictionary.add(("text displayed"));
    }

    private void initAssertIsTextNullDictionary() {
        assetIsTextNullDictionary.add("field");
        assetIsTextNullDictionary.add("text");
    }

    public Event search(String action) {
        return search(assertMap, action);
    }


}
