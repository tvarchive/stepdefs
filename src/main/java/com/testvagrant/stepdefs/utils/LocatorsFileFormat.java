package com.testvagrant.stepdefs.utils;


import com.testvagrant.stepdefs.core.OptimusConfiguration;
import com.testvagrant.stepdefs.exceptions.InvalidElementsFormatException;

import java.io.File;
import java.util.Arrays;

import static com.testvagrant.commons.utils.OptimusConfigMapper.mapper;

public class LocatorsFileFormat {

    private LocatorsFileFormat() {

    }

    public static LocatorsFileFormat locatorsFF() {
        return new LocatorsFileFormat();
    }

    public LocatorsFileFormat.LocFileFormats getFormat() throws InvalidElementsFormatException {
        return elementsMapper();
    }


    private LocFileFormats elementsMapper() throws InvalidElementsFormatException {
        File file = new File(System.getProperty("user.dir") + "/src/test/resources/META-INF/Optimus.yaml");
        if(file.exists()) {
            OptimusConfiguration configuration = null;
            try {
                configuration =  mapper(file).map(OptimusConfiguration.class);
                return LocFileFormats.valueOf(configuration.getElementsFormat().toUpperCase());
            } catch (Exception e) {
                throw new InvalidElementsFormatException(configuration.getElementsFormat(),LocFileFormats.acceptableFormats());
            }
        }else {
            return LocFileFormats.JSON;
        }
    }


    public enum LocFileFormats {
        ELEMENTS(".elements"),
        JSON(".json"),
        XLS(".xls"),
        XLSX(".xlsx");

        private String formatExtension;
        LocFileFormats(String formatExtension) {
            this.formatExtension = formatExtension;
        }

        public String getFormatExtension() {
            return formatExtension;
        }

        public static String acceptableFormats() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            Arrays.stream(LocFileFormats.values()).forEach(locFileFormats -> stringBuilder.append(locFileFormats.name().toLowerCase()+","));
            stringBuilder.append("]");
            String builderString = stringBuilder.toString();
            String acceptableformats = builderString.replace(builderString.substring(builderString.lastIndexOf(",")),"");
            return acceptableformats+"]";
        }
    }
}
