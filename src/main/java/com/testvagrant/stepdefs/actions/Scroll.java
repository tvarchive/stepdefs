package com.testvagrant.stepdefs.actions;


import com.testvagrant.stepdefs.core.events.Event;

import static com.testvagrant.stepdefs.core.events.EventCodes.*;

public enum Scroll implements Event {
    SCROLL_UP(SCROLL_UP_CODE),
    SCROLL_DOWN(SCROLL_DOWN_CODE);

    private String code;
    Scroll(String  code) {
        this.code = code;
    }

    public String  getEventCode() {
        return code;
    }
}
