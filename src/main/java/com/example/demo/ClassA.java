package com.example.demo;

import org.slf4j.Logger;

public class ClassA {
    protected org.slf4j.Logger logger = CiLoggerFactory.getLogger(ClassA.class);
    public void print() throws InterruptedException {
        logger.info("ClassA");
        Thread.sleep(1000);
        ClassB b = new ClassB();
        b.print();
    }
}
