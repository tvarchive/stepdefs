package com.testvagrant.stepdefs.utils;


import com.testvagrant.stepdefs.core.OptimusConfiguration;
import com.testvagrant.stepdefs.exceptions.InvalidElementsFormatException;

import java.io.File;
import java.util.Arrays;

import static com.testvagrant.stepdefs.utils.ConfigMapper.mapper;

public class LocatorsFileFormat {

    private LocatorsFileFormat() {

    }

    public static LocatorsFileFormat locatorsFF() {
        return new LocatorsFileFormat();
    }

    public String getFormat() throws InvalidElementsFormatException {
        return elementsMapper().getFormat();
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


    private enum LocFileFormats {
        ELEMENTS(".elements"),
        JSON(".json"),
        XLS(".xls"),
        XLSX(".xlsx");

        private String format;
        LocFileFormats(String format) {
            this.format = format;
        }

        public String getFormat() {
            return format;
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
