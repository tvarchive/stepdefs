package com.testvagrant.stepdefs.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class ConfigMapper {
    private File configFile;
    private ConfigMapper(File file) {
        this.configFile = file;
    }

    public static ConfigMapper mapper(File file) {
        return new ConfigMapper(file);
    }


    public <T> T map(Class<T> tClass) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(configFile,tClass);
    }
}

