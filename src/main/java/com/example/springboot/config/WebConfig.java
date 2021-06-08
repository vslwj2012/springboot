package com.example.springboot.config;

import com.example.springboot.interceptor.ApiInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootConfiguration
public class WebConfig extends WebMvcConfigurationSupport {

    @Autowired
    private ApiInterceptor apiInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiInterceptor);
    }
}
