package com.testvagrant.stepdefs.actions;

import com.testvagrant.stepdefs.core.events.Event;

import static com.testvagrant.stepdefs.core.events.EventCodes.SELECT_DROPDOWN_TEXT_CODE;

public enum Select implements Event {
    SELECT_DROPDOWN_TEXT(SELECT_DROPDOWN_TEXT_CODE);

    private String eventCode;

    Select(String eventCode) {
        this.eventCode = eventCode;
    }

    @Override
    public String getEventCode() {
        return eventCode;
    }
}
