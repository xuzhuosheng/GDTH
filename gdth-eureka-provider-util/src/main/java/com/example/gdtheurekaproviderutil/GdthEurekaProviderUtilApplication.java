package com.example.gdtheurekaproviderutil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class GdthEurekaProviderUtilApplication {

    public static void main(String[] args) {
        SpringApplication.run(GdthEurekaProviderUtilApplication.class, args);
    }

}
