package cn.cuiper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

public class TestLog {

    private static final Logger logger = LoggerFactory.getLogger(TestLog.class);

    public static void main(String[] args) {
        logger.info("I am info log.");
        logger.error("I am error log.");
        logger.warn("I am warn log.");
    }

}
