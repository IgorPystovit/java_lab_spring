package com.igorpystovit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TestExceptions {
    private static Logger logger = LogManager.getLogger(TestExceptions.class.getName());

    public static void main(String[] args) {
        logger.info("info messa");
        logger.fatal("fatal messa");
        logger.error("error messa");
        logger.warn("warn messa");
        logger.debug("debug messa");
    }
}
