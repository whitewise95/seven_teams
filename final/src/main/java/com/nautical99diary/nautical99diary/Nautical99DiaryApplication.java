package com.nautical99diary.nautical99diary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Nautical99DiaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(Nautical99DiaryApplication.class, args);
    }

}
