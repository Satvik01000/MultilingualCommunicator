package com.hackathon.hackhazards.multilingualcommunicator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MultilingualCommunicatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultilingualCommunicatorApplication.class, args);
    }

}
