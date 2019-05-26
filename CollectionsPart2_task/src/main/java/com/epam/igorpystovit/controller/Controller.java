package com.epam.igorpystovit.controller;

import com.epam.igorpystovit.model.BinaryTree;
import com.epam.igorpystovit.model.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Controller {
    private Logger logger = LogManager.getLogger(Controller.class.getName());
    private BinaryTree<Integer,String> binaryTree = new BinaryTree<>();

    public int getBinaryTreeSize(){
        logger.info("Binary tree size = "+binaryTree.size());
        return binaryTree.size();
    }

    public boolean removeValueFromTree(){
        logger.info("Input key");
        Integer key = Reader.readInt();
        boolean modified = binaryTree.remove(key);
        if (modified){
            logger.info("Pair key/value removed");
        }else{
            logger.warn("Bad key input");
        }
        return modified;
    }

    public boolean putValueIntoTree(){
        logger.info("Input key");
        Integer key = Reader.readInt();
        logger.info("Input value");
        String value = Reader.readString();
        boolean modified = binaryTree.put(key,value);
        if (modified){
            logger.info("Key has been put into map");
        }else{
            logger.warn("Something went wrong");
        }
        return modified;
    }

    public boolean treeContainsKey(){
        logger.info("Input key");
        Integer key = Reader.readInt();
        boolean contains = binaryTree.contains(key);
        if (contains){
            logger.info("Contains");
        }else{
            logger.info("Does not contain");
        }
        return contains;
    }

    public void print(){
        logger.info("Your binary tree");
        logger.info(binaryTree);
    }

    public String getValueFromTree(){
        logger.info("Input key");
        Integer key = Reader.readInt();
        String value = binaryTree.get(key);
        if (value != null){
            logger.info(key+" = "+value);
        }
        return value;
    }
}
