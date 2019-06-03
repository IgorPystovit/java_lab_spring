package com.epam.igorpystovit.controller;

import com.epam.igorpystovit.model.Reader;
import com.epam.igorpystovit.model.StringHandler;
import com.epam.igorpystovit.model.TextHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.*;

public class Controller {
    private static Logger logger = LogManager.getLogger(Controller.class.getName());
    private static final StringHandler stringHandler = new StringHandler();
    private ResourceBundle resourceBundle;
    private String country = "US";
    private String language = "en";
    private TextHandler textHandler = new TextHandler(language,country);
    private static Reader reader;


    public Controller(){
        resourceBundle = ResourceBundle.getBundle("enUS");
        reader = new Reader(resourceBundle);
    }

    public Controller(ResourceBundle resourceBundle){
        this.resourceBundle = resourceBundle;
        textHandler = new TextHandler(resourceBundle);
        reader = new Reader(resourceBundle);
    }

    public Controller(String language,String country){
        this.language = language;
        this.country = country;
        resourceBundle = ResourceBundle.getBundle(language+country);
        textHandler = new TextHandler(language,country);
        reader = new Reader(resourceBundle);
    }

    //count total number of words in file
    public int countWords(File file){
        int totalWordNum = 0;
        if (textHandler.ensureTxtExtension(file)){
            List<String> sentences = textHandler.parseTextWithPunctuationMarks(file);
            for (String tempSentence : sentences){
                totalWordNum += textHandler.countWords(tempSentence);
            }
            logger.info(resourceBundle.getString("Result.totalWordNumber")+" : "+totalWordNum);
        }else{
            logger.warn(resourceBundle.getString("Exception.wrongExtension"));
        }
        return totalWordNum;
    }

    public boolean ensureTxtExtension(File file){
        if (file == null){
            logger.error(resourceBundle.getString("Exception.textFileNotInitialized"));
            return false;
        }
        return textHandler.ensureTxtExtension(file);
    }
    //finds all the sentences which contain specified word
    public List<String> findEntries(File file,String word){
        List<String> sentencesWithWord = textHandler.findEntries(file,word);
        if (sentencesWithWord.size() > 0){
            logger.info(resourceBundle.getString("Result.sentencesWithWord"));
            sentencesWithWord.stream().forEach(System.out::println);
        } else {
            logger.info(resourceBundle.getString("Result.noSentencesFound"));
        }
        return sentencesWithWord;
    }

    //replaces all vowels in given text
    public String replaceVowels(){
        String string = reader.readString();
        if (string != null){
            string = stringHandler.replaceVowels(string);
            logger.info(resourceBundle.getString("Result.changedString")+" : "+string);
        }
        return string;
    }

    //splits sentence with regular expression
    public String[] splitString(String sentence, String regEx){
        String[] splitResult = null;
        if (sentence != null){
            splitResult = stringHandler.sentenceSplitter(sentence,regEx);
            logger.info(resourceBundle.getString("Result.resultOfSplit"));
            Arrays.stream(splitResult).forEach(System.out::println);
        }
        return splitResult;
    }

    //sorts words by first letter
    public List<String> sortWordsByFirstLetter(File file){
        List<String> sortedWords = new LinkedList<>();
        if (textHandler.ensureTxtExtension(file)){
            List<String> sentences = textHandler.parseTextWithPunctuationMarks(file);
            sortedWords = textHandler.sortWords(sentences);
            logger.info(resourceBundle.getString("Result.sortedWords"));
            sortedWords.stream().forEach(System.out::println);
        }else{
            logger.warn(resourceBundle.getString("Exception.wrongExtension"));
        }
        return sortedWords;
    }

    //sorts sentences by number of words im them
    public List<String> sortSentencesByWordNum(File file){
        List<String> sortedSentences = new LinkedList<>();
        if (textHandler.ensureTxtExtension(file)){
            List<String> sentences = textHandler.parseTextWithPunctuationMarks(file);
            sortedSentences = textHandler.sortSentences(sentences);
            logger.info(resourceBundle.getString("Result.sortedSentences"));
            sortedSentences.stream().forEach(System.out::println);
        } else {
            logger.warn(resourceBundle.getString("Exception.wrongExtension"));
        }
        return sortedSentences;
    }

    //finds words of specified length in questions
    public Set<String> findWordsInQuestions(File file,int length){
        Set<String> words = new LinkedHashSet<>();
        if (textHandler.ensureTxtExtension(file)){
            words = textHandler.findWordsInQuestions(textHandler.parseTextWithPunctuationMarks(file),length);
            if (words.size() > 0){
                logger.info(resourceBundle.getString("Result.foundWords"));
                words.stream().forEach(System.out::println);
            } else {
                logger.info(resourceBundle.getString("Info.noWordsWereFound"));
            }
        } else {
            logger.warn(resourceBundle.getString("Exception.wrongExtension"));
        }
        return words;
    }

    //counts number of entries of every inputted word
    public Map<String,Integer> countWordEntries(File file){
        Map<String,Integer> wordsEntries = new LinkedHashMap<>();
        if (textHandler.ensureTxtExtension(file)){
            Set<String> words = new LinkedHashSet<>(reader.endlessStringReader());
            List<String> sentences = textHandler.parseTextWithPunctuationMarks(file);
            wordsEntries = textHandler.countWordsEntries(words,sentences);
            logger.info(resourceBundle.getString("Result.wordsAndEntriesNum"));
            wordsEntries.entrySet().stream()
                    .forEach(a -> System.out.println(a.getKey()+"->"+a.getValue()));
        } else {
            logger.warn(resourceBundle.getString("Exception.wrongExtension"));
        }
        return wordsEntries;
    }

    //Parsers that parse file into sentences
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
}
