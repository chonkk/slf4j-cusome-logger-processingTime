package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        Logger logger = CiLoggerFactory.getLogger(DemoApplication.class);
        logger.info("main start");
        MDC.put("startTime", Long.toString(System.currentTimeMillis()));
        ClassA a = new ClassA();
        try {
            a.print();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("main end");
    }

}
