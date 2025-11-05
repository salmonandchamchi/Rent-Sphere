package com.niit.lease;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AdminWebApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(AdminWebApplication.class, args);
    }
}
