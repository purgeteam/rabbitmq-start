package com.rabbit.consumer.bootstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author purgeyao
 * @version 1.0
 */
@SpringBootApplication(scanBasePackages = "com")
public class ConsumerBootstart {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerBootstart.class, args);
    }

}
