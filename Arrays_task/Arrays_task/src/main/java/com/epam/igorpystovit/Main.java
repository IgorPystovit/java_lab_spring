package com.epam.igorpystovit;

import com.epam.igorpystovit.view.MainMenu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Main.class.getName());
        new MainMenu().launch();
    }
}
