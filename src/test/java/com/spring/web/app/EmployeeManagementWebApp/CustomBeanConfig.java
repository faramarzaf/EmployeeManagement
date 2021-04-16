package com.spring.web.app.EmployeeManagementWebApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.FilterChainProxy;

@Configuration
public class CustomBeanConfig {

    @Bean
    public FilterChainProxy getFilterChainProxy() {
        return new FilterChainProxy();
    }
}