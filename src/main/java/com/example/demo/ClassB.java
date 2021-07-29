package com.example.demo;

public class ClassB {
    protected org.slf4j.Logger logger = CiLoggerFactory.getLogger(ClassB.class);
    public void print() throws InterruptedException {
        logger.info("ClassB");
        ClassC c = new ClassC();
        Thread.sleep(1000);
        c.print();
    }
}
