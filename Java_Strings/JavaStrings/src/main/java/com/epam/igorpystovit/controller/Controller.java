package com.epam.igorpystovit.controller;

import com.epam.igorpystovit.model.StringHandler;
import com.epam.igorpystovit.model.TextHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller {
    private String country = "US";
    private String language = "en";
    private static Logger logger = LogManager.getLogger(Controller.class.getName());
    private static final StringHandler stringHandler = new StringHandler();
    private TextHandler textHandler = new TextHandler(language,country);
    private ResourceBundle resourceBundle;
    public Controller(){
        resourceBundle = ResourceBundle.getBundle("enUS");
    }
    public Controller(String language,String country){
        this.language = language;
        this.country = country;
        resourceBundle = ResourceBundle.getBundle(language+country);
        textHandler = new TextHandler(language,country);
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public String getLanguage() {
        return language;
    }

    public
    public List<String> parseText(File file){
        List<String> sentences = textHandler.parseTextWithPunctuationMarks(file);
        logger.info(resourceBundle.getString("Result.parsedText"));
        sentences.stream()
                .forEach(System.out::println);
        return sentences;
    }

    public List<String> parseTextWithPunctuationMarks(File file){
        List<String> sentences = textHandler.parseTextWithPunctuationMarks(file);
        logger.info(resourceBundle.getString("Result.parsedTextWithPunctuationMarks"));
        sentences.stream()
                .forEach(System.out::println);
        return sentences;
    }

    public List<String> parseTextWithPunctuationMarks(String text){
        List<String> sentences = textHandler.parseTextWithPunctuationMarks(text);
        logger.info(resourceBundle.getString("Result.parsedTextWithPunctuationMarks"));
        sentences.stream()
                .forEach(System.out::println);
        return sentences;
    }

}
