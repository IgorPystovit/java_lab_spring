package com.epam.igorpystovit.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextHandler {
    private static Logger logger = LogManager.getLogger(TextHandler.class.getName());
    private ResourceBundle resourceBundle;
    private String language;
    private String country;

    public TextHandler(){
        resourceBundle = ResourceBundle.getBundle("enUS");
    }

    public TextHandler(String language,String country){
        this.country = country;
        this.language = language;
        try{
            resourceBundle = ResourceBundle.getBundle(language+country);
        } catch (MissingResourceException e){
            logger.error("Wrong property file");
            resourceBundle = ResourceBundle.getBundle("enUS");
        } catch (Exception e){
            logger.error("Something went wrong");
        }
    }

    public List<String> parseText(File file){
        List<String> sentences = new LinkedList<>();
        if (ensureTxtExtension(file)){
            String textLine = null;
            try(FileReader fileReader = new FileReader(file)){
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                do{
                    textLine = deleteSpaces(textLine);
                    StringTokenizer stringTokenizer = new StringTokenizer(textLine,".!?");
                    while (stringTokenizer.hasMoreTokens()){
                        String sentence = stringTokenizer.nextToken();
                        if (!sentence.equals(" ")){
                            sentences.add(sentence);
                        }
                    }
                }while ((textLine = bufferedReader.readLine()) != null);

            } catch (FileNotFoundException e){
                logger.error(resourceBundle.getString("Exception.wrongFilePath"));
            } catch (Exception e){
                logger.error(resourceBundle.getString("Exception.sthWentWrong"));
            }
        }
        return sentences;
    }

    public List<String> parseTextWithPunctuationMarks(File file){
        List<String> sentences = new LinkedList<>();
        if (ensureTxtExtension(file)){
            int sentenceBegin = 0;
            int sentenceEnd = 0;
            String textLine = null;
            try(FileReader fileReader = new FileReader(file)){
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                do{
                    textLine = deleteSpaces(textLine);
                    char[] charSentence = textLine.toCharArray();
                    String sentence = "";
                    for (int i = 0; i < charSentence.length; i++){
                        if ((charSentence[i] =='.') || (charSentence[i] == '?') || (charSentence[i] == '!')){
                            sentenceEnd = i;
                            sentence = textLine.substring(sentenceBegin,sentenceEnd);
                            if (!sentence.equals(" ")){
                                sentences.add(sentence+charSentence[i]);
                                sentenceBegin = sentenceEnd+1;
                            }
                        }
                    }
                    sentenceBegin = 0;
                    sentenceEnd = 0;
                }while ((textLine = bufferedReader.readLine()) != null);

            } catch (FileNotFoundException e){
                logger.error(resourceBundle.getString("Exception.wrongFilePath"));
            } catch (Exception e){
                e.printStackTrace();
                logger.error(resourceBundle.getString("Exception.sthWentWrong"));
            }

        }
        return sentences;
    }

    public List<String> parseTextWithPunctuationMarks(String text){
        List<String> sentences = new LinkedList<>();
        int sentenceBegin = 0;
        int sentenceEnd = 0;

        text = deleteSpaces(text);
        char[] charSentence = text.toCharArray();
        String sentence = "";
        for (int i = 0; i < charSentence.length; i++){
            if ((charSentence[i] =='.') || (charSentence[i] == '?') || (charSentence[i] == '!')){
                sentenceEnd = i;
                sentence = text.substring(sentenceBegin+1,sentenceEnd);
                if (!sentence.equals(" ")){
                    sentences.add(sentence+charSentence[i]);
                    sentenceBegin = sentenceEnd;
                }
            }
        }
        return sentences;
    }
    
    private String deleteSpaces(String sentence){
        if (sentence == null){
            return "";
        }
        char[] charSentence =  sentence.toCharArray();
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < charSentence.length; i++){

            if (charSentence[i] == ' '){
                startIndex = i;
                int j;
                for (j = i; j < charSentence.length; j++){
                    if (charSentence[j] != ' '){
                        endIndex = j;
                        break;
                    }
                }
                i = j;
                if ((endIndex - startIndex) > 1){
                    charSentence = deleteChars(charSentence,startIndex,endIndex-2);
                }
            }
        }
        return String.valueOf(charSentence);
    }

    private char[] deleteChars(char[] charSequence,int startIndex,int endIndex){
        int elementNum = Math.abs(endIndex - startIndex +1);
        char[] newCharSequence = new char[charSequence.length - elementNum];
        int counter = 0;
        for (int i = 0; i < charSequence.length; i++){
            if ((i < startIndex) || (i > endIndex)){
                newCharSequence[counter++] = charSequence[i];
            }
        }
        return newCharSequence;
    }

    private boolean ensureTxtExtension(File file){
        String fileName = file.getName();
        return fileName.substring(fileName.length()-3).equals("txt");
    }

    private int countWords(String sentence){
        StringTokenizer wordParser = new StringTokenizer(sentence," ,");
        int wordCounter = 0;
        while(wordParser.hasMoreTokens()){
            String tempWord =  wordParser.nextToken();
            if ((!tempWord.equals(" ")) && (!tempWord.equals(","))){
                wordCounter++;
            }
        }
        return wordCounter;
    }

    public List<String> sortSentences(List<String> sentences){
        for (int i = 0; i < sentences.size(); i++){
            for (int j = 0; j < sentences.size()-1; j++){
                if (countWords(sentences.get(j)) > countWords(sentences.get(j+1))){
                    String temp = sentences.get(j);
                    sentences.set(j,sentences.get(j+1));
                    sentences.set(j+1,temp);
                }
            }
        }
        return sentences;
    }

    public List<String> sortWords(List<String> words){
        List<String> words = new LinkedList<>();
        for (String tempWord : sentences){
            words.addAll(parseSentences(tempWord));
        }


        for (int i = 0; i < words.size(); i++){
            for (int j = 0; j < words.size() - 1; j++){
                char[] word1 = words.get(j).toCharArray();
                char[] word2 = words.get(j+1).toCharArray();
                if (word1[0] > word2[0]){
                    String temp = words.get(j);
                    words.set(j,words.get(j+1));
                    words.set(j+1,temp);
                }
            }
        }
        return words;
    }

    public Set<String> findWordsInQuestions(List<String> sentences,int wordLength){
        Set<String> words = new LinkedHashSet<>();
        List<String> questions = sentences.stream()
                .filter(a -> a.charAt(a.length()-1) == '?')
                .collect(Collectors.toList());
        for (String question : questions){
            words.addAll(parseSentences(question).stream()
                    .filter(a -> a.length() == wordLength)
                    .collect(Collectors.toSet()));
        }
        return words;
    }

    public List<String> parseSentences(String sentence){
        List<String> words = new LinkedList<>();
        StringTokenizer wordParser = new StringTokenizer(sentence," ,.?!");
        while(wordParser.hasMoreTokens()){
            String tempWord = wordParser.nextToken();
            if ((!tempWord.equals("!")) && (!tempWord.equals("?")) && (!tempWord.equals("."))){
                words.add(tempWord);
            }
        }
        return words;
    }

    public Map<String,Integer> countWordsEntries(Set<String> words,List<String> sentences){
        List<String> parsedSentences = new LinkedList<>();
        Map<String,Integer> wordEntries = new LinkedHashMap<>();
        int entryCounter = 0;

        for (String sentence :sentences){
            parsedSentences.addAll(parseSentences(sentence));
        }

        for (String word : words){
            for (String sentencesWord : parsedSentences){
                if (word.equalsIgnoreCase(sentencesWord)){
                    entryCounter++;
                }
            }
            wordEntries.put(word,entryCounter);
            entryCounter = 0;
        }

        wordEntries = wordEntries.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(e -> e.getKey(),e -> e.getValue(),(e1,e2) -> e2,LinkedHashMap::new));
        return wordEntries;
    }

    public List<String> findEntries(File file,String word){
        List<String> sentencesWithEntries = new LinkedList<>();
        List<String> sentences = parseTextWithPunctuationMarks(file);

        for (String sentence : sentences){
            List<String> parsedSentence = parseSentences(sentence);
            for (String tempWord : parsedSentence){
                if (tempWord.equalsIgnoreCase(word)){
                    sentencesWithEntries.add(sentence);
                    break;
                }
            }
        }
        return sentencesWithEntries;
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


    public static void main(String[] args) {
        TextHandler textHandler = new TextHandler();
        String path = "/home/wage/randomText.txt";
        System.out.println(textHandler.findEntries(new File(path),"avOid"));
        List<String> sentences = textHandler.parseTextWithPunctuationMarks(new File((path)));
//        Set<String> words = new LinkedHashSet<>();
//        words.addAll(Arrays.asList("Whole","OR"));
//        Map<String,Integer> wordsEntries = textHandler.countWordsEntries(words,sentences);
//        System.out.println(wordsEntries);

    }
}
