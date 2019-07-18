package com.example.gdtheurekaproviderywgn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
@MapperScan ("com.example.gdtheurekaproviderywgn.dao")
public class GdthEurekaProviderYwgnApplication {

    public static void main(String[] args) {
        SpringApplication.run(GdthEurekaProviderYwgnApplication.class, args);
    }

}
