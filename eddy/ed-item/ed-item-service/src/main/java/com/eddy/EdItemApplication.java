package com.eddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.eddy.item.mapper")
public class EdItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(EdItemApplication.class, args);
    }
}
