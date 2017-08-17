package com.testvagrant.stepdefs.actions;

import com.testvagrant.stepdefs.core.events.Event;

import static com.testvagrant.stepdefs.core.events.EventCodes.*;
import static com.testvagrant.stepdefs.core.events.EventCodes.ASSERT_IS_NOT_VISIBLE_CODE;
import static com.testvagrant.stepdefs.core.events.EventCodes.ASSERT_IS_VISIBLE_CODE;

public enum Upload implements Event {
    UPLOAD(UPLOAD_CODE);

    private String code;

    Upload(String code) {
        this.code = code;
    }

    @Override
    public String getEventCode() {
        return code;
    }
}
