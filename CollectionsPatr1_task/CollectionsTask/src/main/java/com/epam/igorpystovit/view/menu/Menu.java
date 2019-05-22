package com.epam.igorpystovit.view.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

@FunctionalInterface
public interface Menu {
    Logger logger = LogManager.getLogger(Menu.class.getName());
    void show();
}
