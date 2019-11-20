package com.tinyv.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author YMa69
 * @date 2019/11/8.
 */
@SpringBootApplication
@EnableCaching
public class MyApps {

    public static Logger logger = LoggerFactory.getLogger(MyApps.class);

    public static void main(String[] args) {
        logger.info("=========== MyApps start =============");
        SpringApplication.run(MyApps.class, args);
    }

}
