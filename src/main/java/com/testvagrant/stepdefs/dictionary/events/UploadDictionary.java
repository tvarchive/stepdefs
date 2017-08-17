package com.testvagrant.stepdefs.dictionary.events;

import com.testvagrant.stepdefs.actions.Upload;
import com.testvagrant.stepdefs.core.events.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UploadDictionary extends EventDictionary {

    private List<String> uploadDictionary;

    private Map<Event, List<String>> uploadMap;

    private UploadDictionary() {
        uploadDictionary = new ArrayList<>();
        uploadMap = new HashMap<>();
    }

    public static UploadDictionary uploadDictionary() {
        return new UploadDictionary();
    }

    public UploadDictionary open() {
        return new UploadDictionary().init();
    }

    public Event search(String action) {
        return search(uploadMap, action);
    }

    private UploadDictionary init() {
        initSelectDictionary();
        uploadMap.put(Upload.UPLOAD, uploadDictionary);
        return this;
    }

    private void initSelectDictionary() {
        uploadDictionary.add("upload");
        uploadDictionary.add("uploads");
    }
}