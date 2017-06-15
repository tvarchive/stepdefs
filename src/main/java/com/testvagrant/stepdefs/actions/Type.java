package com.testvagrant.stepdefs.actions;


import com.testvagrant.stepdefs.core.events.Event;

import static com.testvagrant.stepdefs.core.events.EventCodes.TYPE_CODE;

public enum  Type implements Event {

    TYPE(TYPE_CODE);
    private String  code;
    Type(String  code) {
        this.code = code;
    }
    @Override
    public String  getEventCode() {
        return code;
    }
}
