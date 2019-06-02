package com.epam.igorpystovit.model;

import java.util.ResourceBundle;

public enum LanguageFormatter {
    ENGLISH(ResourceBundle.getBundle("enUS")),
    РУССКИЙ(ResourceBundle.getBundle("ruRUS")),
    DEUTCH(ResourceBundle.getBundle("nlDE"));

    ResourceBundle resourceBundle;
    LanguageFormatter(ResourceBundle resourceBundle){
        this.resourceBundle = resourceBundle;
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }
}
