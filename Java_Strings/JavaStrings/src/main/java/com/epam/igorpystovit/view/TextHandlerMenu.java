package com.epam.igorpystovit.view;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public class TextHandlerMenu extends Menu{

    private File textFile;

    public TextHandlerMenu(){

    }



    @Override
    public Map<Integer, Runnable> initializeActions() {
        if (textFile == null){
//            logger.info(resourceBundle.getString("Info.inputFilePath"));
            textFile = reader.readTextFile();
        }
        Map<Integer,Runnable> menuActions = new LinkedHashMap<>(){{
           put(1,() -> controller.countWords(textFile));
           put(2,() -> {
               logger.info(resourceBundle.getString("Info.inputWord"));
               controller.findEntries(textFile,reader.readString());
           });
           put(3,() -> controller.sortWordsByFirstLetter(textFile));
           put(4,() -> controller.sortSentencesByWordNum(textFile));
           put(5,() -> {
              logger.info(resourceBundle.getString("Info.inputWordLength"));
              controller.findWordsInQuestions(textFile,reader.readInt());
           });
           put(6,() -> controller.countWordEntries(textFile));
           put(7,() -> textFile = reader.readTextFile());
        }};
        return menuActions;
    }

    @Override
    public Map<Integer, String> initializeItems() {
        Map<Integer,String> menuItems = new LinkedHashMap<>(){{
           put(1,resourceBundle.getString("Menu.countNumberOfWords"));
           put(2,resourceBundle.getString("Menu.findAllEntriesOfWordInFile"));
           put(3,resourceBundle.getString("Menu.sortWordsByFirstLetter"));
           put(4,resourceBundle.getString("Menu.sortSentencesByWordNum"));
           put(5,resourceBundle.getString("Menu.findWordsInQuestions"));
           put(6,resourceBundle.getString("Menu.countEntriesOfWordSet"));
           put(7,resourceBundle.getString("Menu.setTextFilePath"));
        }};
        return menuItems;
    }
}
