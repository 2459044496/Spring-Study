package cn.cuiper;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLog {

    private static final Logger logger = LoggerFactory.getLogger(cn.cuiper.TestLog.class);

    @Test
    public void testLog() {
        logger.info("I am info log.");
        logger.error("I am error log.");
        logger.warn("I am warn log.");
    }
}
