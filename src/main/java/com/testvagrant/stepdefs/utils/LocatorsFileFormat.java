package com.testvagrant.stepdefs.utils;


import com.testvagrant.commons.entities.OptimusConfiguration;
import com.testvagrant.stepdefs.exceptions.InvalidElementsFormatException;

import java.util.Arrays;

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
        OptimusConfiguration configuration = null;
        try {
            return LocFileFormats.valueOf(Commons.getOptimusConfiguration().getElementsFormat().toUpperCase());
        } catch (Exception e) {
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
