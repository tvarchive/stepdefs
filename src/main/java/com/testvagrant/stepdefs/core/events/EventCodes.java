package com.testvagrant.stepdefs.core.events;

public interface EventCodes {
    String TAP_CODE = "00001";
    String DOUBLE_TAP_CODE = "00010";
    String SCROLL_UP_CODE = "00011";
    String SCROLL_DOWN_CODE = "00100";
    String SWIPE_LEFT_CODE = "00101";
    String SWIPE_RIGHT_CODE = "00110";
    String SLIDE_CODE = "00111";
    String TYPE_CODE = "01000";
    String ASSERT_IS_DISPLAYED_CODE = "01001";
    String ASSERT_IS_NOT_DISPLAYED_CODE = "01010";
    String ASSERT_IS_ENABLED_CODE = "01011";
    String ASSERT_IS_NOT_ENABLED_CODE = "01100";
    String ASSERT_IS_VISIBLE_CODE = "01101";
    String ASSERT_IS_NOT_VISIBLE_CODE = "01110";
    String SCROLL_UP_IN_ELEMENT_CODE = "01111";
    String SCROLL_DOWN_IN_ELEMENT_CODE = "10000";
    String SCROLL_LEFT_IN_ELEMENT_CODE = "10001";
    String SCROLL_RIGHT_IN_ELEMENT_CODE = "10010";
    String NAVIGATE_BACK_CODE = "10011";
    String NAVIGATE_FORWARD_CODE = "10100";
    String REFRESH_CODE = "10101";
    String HIDE_KEYBOARD_CODE = "10110";
}
