package com.testvagrant.stepdefs.actions;


import com.testvagrant.stepdefs.core.events.Event;

import static com.testvagrant.stepdefs.core.events.EventCodes.*;

public enum Swipe implements Event {
    SWIPE_LEFT(SWIPE_LEFT_CODE),
    SWIPE_RIGHT(SWIPE_RIGHT_CODE);

    private String code;
    Swipe(String code) {
        this.code = code;
    }

    public String getEventCode() {
        return code;
    }
}
