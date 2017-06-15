package com.testvagrant.stepdefs.actions;


import com.testvagrant.stepdefs.core.events.Event;

import static com.testvagrant.stepdefs.core.events.EventCodes.SLIDE_CODE;

public enum Slide implements Event {

    SLIDE(SLIDE_CODE);
    private String code;
    Slide(String code) {
        this.code = code;
    }

    public String getEventCode() {
        return code;
    }
}
