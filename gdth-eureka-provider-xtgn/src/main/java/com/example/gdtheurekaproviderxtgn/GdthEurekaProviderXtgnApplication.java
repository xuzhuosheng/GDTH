package com.example.gdtheurekaproviderxtgn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
public class GdthEurekaProviderXtgnApplication {

    public static void main(String[] args) {
        SpringApplication.run(GdthEurekaProviderXtgnApplication.class, args);
    }

}
