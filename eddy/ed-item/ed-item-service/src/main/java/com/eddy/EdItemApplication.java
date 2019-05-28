package com.eddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EdItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(EdItemApplication.class, args);
    }
}
