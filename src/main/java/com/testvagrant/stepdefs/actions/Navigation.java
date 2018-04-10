package com.testvagrant.stepdefs.actions;

import com.testvagrant.stepdefs.core.events.Event;

import static com.testvagrant.stepdefs.core.events.EventCodes.*;

public enum Navigation implements Event {

    NAVIGATE_BACK(NAVIGATE_BACK_CODE),
    NAVIGATE_FORWARD(NAVIGATE_FORWARD_CODE),
    REFRESH(REFRESH_CODE),
    HIDE_KEYBOARD(HIDE_KEYBOARD_CODE);

    private String code;

    Navigation(String code) {
        this.code = code;
    }

    @Override
    public String getEventCode() {
        return code;
    }
}
