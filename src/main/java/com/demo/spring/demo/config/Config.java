package com.demo.spring.demo.config;

import com.demo.spring.demo.rest.RestControllerInterceptor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {

    @Autowired
    RestControllerInterceptor restControllerInterceptor;

    @Bean
    public ModelMapper modelMapperBean(){
        return new ModelMapper();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(restControllerInterceptor).addPathPatterns("/**");
    }
}
