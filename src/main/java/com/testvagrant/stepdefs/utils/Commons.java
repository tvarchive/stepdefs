package com.testvagrant.stepdefs.utils;

import com.testvagrant.commons.entities.OptimusConfiguration;

import java.io.File;

import static com.testvagrant.commons.utils.OptimusConfigMapper.mapper;

public class Commons {

    public static OptimusConfiguration getOptimusConfiguration() {
        File file = new File(System.getProperty("user.dir") + "/src/test/resources/META-INF/Optimus.yaml");
        if (file.exists()) {
            OptimusConfiguration configuration = null;
            try {
                return configuration = mapper(file).map(OptimusConfiguration.class);
            } catch (Exception e) {

            }
        }
        return new OptimusConfiguration();
    }

}
