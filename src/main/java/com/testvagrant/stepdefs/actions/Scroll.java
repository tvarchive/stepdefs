package com.testvagrant.stepdefs.actions;


import com.testvagrant.stepdefs.core.events.Event;

import static com.testvagrant.stepdefs.core.events.EventCodes.*;

public enum Scroll implements Event {
    SCROLL_UP(SCROLL_UP_CODE),
    SCROLL_DOWN(SCROLL_DOWN_CODE),
    SCROLL_UP_TO_ELEMENT(SCROLL_UP_IN_ELEMENT_CODE),
    SCROLL_DOWN_TO_ELEMENT(SCROLL_DOWN_IN_ELEMENT_CODE),
    SCROLL_LEFT_TO_ELEMENT(SCROLL_LEFT_IN_ELEMENT_CODE),
    SCROLL_RIGHT_TO_ELEMENT(SCROLL_RIGHT_IN_ELEMENT_CODE);

    private String code;

    Scroll(String  code) {
        this.code = code;
    }

    public String  getEventCode() {
        return code;
    }
}
