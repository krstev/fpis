package com.fon.fpis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FpisApplication {

    public static void main(String[] args) {
        SpringApplication.run(FpisApplication.class, args);
    }
}
