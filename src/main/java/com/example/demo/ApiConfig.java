package com.example.demo;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {
    @Bean
    public Filter httpsEnforcerFilter(){
        return new HttpsEnforcer();
    }
}