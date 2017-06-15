package com.testvagrant.stepdefs.actions;


import com.testvagrant.stepdefs.core.events.Event;

import static com.testvagrant.stepdefs.core.events.EventCodes.DOUBLE_TAP_CODE;
import static com.testvagrant.stepdefs.core.events.EventCodes.TAP_CODE;

public enum Tap implements Event {

    TAP(TAP_CODE),
    DOUBLETAP(DOUBLE_TAP_CODE);

    private String  code;
    Tap(String  code) {
        this.code = code;
    }

    public String  getEventCode() {
        return code;
    }
}
