package com.m3s.ko;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TreeLogger {

    final static String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    final static Logger logger = Logger.getLogger(TreeLogger.class.getName());

    TreeLogger() {
        initialiseLogging();
    }

    public static void initialiseLogging() {
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
        logger.info("Logging initialised");
    }

    public void setTraceMessage(String message) {
        logger.trace(message);
    }

    public void setErrorMessage(String message) {
        logger.error(message);
    }

    public void displayMessage(String message) {
        logger.debug(message);
    }
}
