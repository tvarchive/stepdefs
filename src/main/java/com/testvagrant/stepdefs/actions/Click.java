package com.testvagrant.stepdefs.actions;

import com.testvagrant.stepdefs.core.events.Event;

import static com.testvagrant.stepdefs.core.events.EventCodes.CLICK_CODE;
import static com.testvagrant.stepdefs.core.events.EventCodes.DOUBLE_CLICK_CODE;

public enum Click implements Event {
    CLICK(CLICK_CODE),
    DOUBLE_CLICK(DOUBLE_CLICK_CODE);

    private String eventCode;

    Click(String eventCode) {
        this.eventCode = eventCode;
    }

    @Override
    public String getEventCode() {
        return eventCode;
    }
}
