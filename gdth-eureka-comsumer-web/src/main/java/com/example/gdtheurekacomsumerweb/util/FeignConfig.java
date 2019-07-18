package com.example.gdtheurekacomsumerweb.util;

import feign.Logger;
import feign.codec.Encoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;


public class FeignConfig {

    @Bean
    @Primary
    @Scope("prototype")
    public Encoder multiPartFormEncoder() {
        return new FeignSpringFormEncoder();
    }


    @Bean
    public feign.Logger.Level multipartLoggerLevel() {
        return Logger.Level.FULL;
    }


}
