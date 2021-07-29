package com.example.demo;

public class ClassC {
    protected org.slf4j.Logger logger = CiLoggerFactory.getLogger(ClassC.class);
    public void print() throws InterruptedException {
        logger.info("ClassC");
        Thread.sleep(1000);
    }
}
