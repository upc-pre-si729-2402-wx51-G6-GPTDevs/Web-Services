package com.tasklinker.tasklinker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.tasklinker.tasklinker")
public class TasklinkerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TasklinkerApplication.class, args);
    }
}
