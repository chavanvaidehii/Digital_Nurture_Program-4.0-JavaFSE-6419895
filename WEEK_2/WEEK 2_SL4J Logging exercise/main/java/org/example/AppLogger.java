package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppLogger {

    private static final Logger log = LoggerFactory.getLogger(AppLogger.class);

    public static void main(String[] args) {
        log.info("Application started successfully");

        log.error("Critical failure occurred in module X");
        log.warn("Configuration is using default values");

        log.info("Application shutting down gracefully");
    }
}

