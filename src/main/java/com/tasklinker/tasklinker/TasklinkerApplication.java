package com.tasklinker.tasklinker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TasklinkerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TasklinkerApplication.class, args);
    }

}
