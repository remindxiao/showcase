package com.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Mail: xiao@terminus.io <br>
 * Date: 2016-07-15 11:05 AM  <br>
 * Author: xiao
 */
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.run(args);
    }
}
