package com.example.gdtheurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class GdthEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GdthEurekaServerApplication.class, args);
    }

}
