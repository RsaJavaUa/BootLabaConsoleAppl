package com.example.demo;

import com.example.demo.services.ConsoleUserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {
    @Autowired
    private ConsoleUserApi consoleUserApi;

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
        ConsoleUserApi bean = run.getBean(ConsoleUserApi.class);
        bean.makeNecklace();
    }
}