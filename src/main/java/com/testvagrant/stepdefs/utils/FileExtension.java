package com.testvagrant.stepdefs.utils;


public enum FileExtension {

    JAVA(".java"),
    TEXT(".txt"),
    SQL(".sql"),
    FEATURE(".feature"),
    EXCEL(".xls"),
    ELEMENTS(".elements"),
    YAML(".yaml");


    private String fileExtension;
    FileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getFileExtension() {
        return fileExtension;
    }

}
