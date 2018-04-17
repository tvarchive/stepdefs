package com.testvagrant.stepdefs.actions;

import com.testvagrant.stepdefs.core.events.Event;

import static com.testvagrant.stepdefs.core.events.EventCodes.*;


/**
 * Created by abhishek on 16/06/17.
 */
public enum  Assert implements Event{
    ASSERT_IS_TEXT_DISPLAYED(ASSERT_IS_DISPLAYED_CODE),
    ASSERT_IS_TEXT_NOT_DISPLAYED(ASSERT_IS_NOT_DISPLAYED_CODE),
    ASSERT_IS_ENABLED(ASSERT_IS_ENABLED_CODE),
    ASSERT_IS_NOT_ENABLED(ASSERT_IS_NOT_ENABLED_CODE),
    ASSERT_IS_VISIBLE(ASSERT_IS_VISIBLE_CODE),
    ASSERT_IS_NOT_VISIBLE(ASSERT_IS_NOT_VISIBLE_CODE);

    private String  code;
    Assert(String  code) {
        this.code = code;
    }

    @Override
    public String  getEventCode() {
        return code;
    }
}
