package com.testvagrant.stepdefs.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.testvagrant.stepdefs.entities.StepDefsConfiguration;
import com.testvagrant.stepdefs.exceptions.MissingStepDefConfigException;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.testvagrant.stepdefs.utils.FileFinder.fileFinder;


public class ConfigParser {

    private StepDefsConfiguration stepDefsConfiguration;
    public ConfigParser() {
        loadConfigFile();
    }

    private void loadConfigFile() {
        String rootPath = System.getProperty("user.dir") + "/src/test/resources/META-INF/";
        List<File> files = fileFinder(rootPath).find(FileExtension.YAML);
        File file = null;
        if(files.size()>0) {
            file = files.get(0);
        } else {
            throw new MissingStepDefConfigException();
        }
        if(file.exists()) {
            try {
                ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
                stepDefsConfiguration =  mapper.readValue(file,StepDefsConfiguration.class);
            } catch (IOException e) {
            }
        }
    }


    public StepDefsConfiguration getConfiguration() {
        return stepDefsConfiguration;
    }
}
