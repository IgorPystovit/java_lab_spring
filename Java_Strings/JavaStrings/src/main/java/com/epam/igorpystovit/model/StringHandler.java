package com.epam.igorpystovit.model;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringHandler {

    public String replaceVowels(String sentence){
        Function<String,String> function = a -> {
            if(Pattern.compile("[aeyoi]").matcher(a).matches()){
                a = "_";
            }
            return a;
        };
        return Arrays.stream(sentence.split(""))
                .map(function).collect(Collectors.joining());
    }

    public String[] sentenceSplitter(String sentence,String splitEx){
        String[] splittedSentence;
        sentence = sentence.toUpperCase();
        splittedSentence = sentence.split(splitEx.toUpperCase());
        return Arrays.stream(splittedSentence)
                .map(String::toLowerCase)
                .toArray(String[]::new);
    }

    public boolean startsWithCapitalCheck(String sentence){
        Pattern pattern = Pattern.compile("[A-Z].*");
        Matcher matcher = pattern.matcher(sentence);
        return matcher.matches();
    }

    public boolean endsWithPeriodCheck(String sentence){
        return Pattern.compile("[a-z]").matcher(sentence).find(sentence.length()-1);
    }
}
