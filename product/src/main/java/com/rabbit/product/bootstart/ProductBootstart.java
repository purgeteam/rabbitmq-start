package com.rabbit.product.bootstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author purgeyao
 * @version 1.0
 */
@SpringBootApplication(scanBasePackages = "com")
public class ProductBootstart {

    public static void main(String[] args) {
        SpringApplication.run(ProductBootstart.class, args);
    }

}
