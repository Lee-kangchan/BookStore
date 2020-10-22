package com.example.demo.config;

import com.example.demo.controller.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Configurations implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns("/home")
                .excludePathPatterns("/book")
                .excludePathPatterns("/book/{seq}")
                .excludePathPatterns("/book/detail/{seq}")
                .excludePathPatterns("/sign")
                .excludePathPatterns("/login")
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/templates/**")
                .excludePathPatterns("/resources/**")
                .excludePathPatterns("/favicon.ico")
                .excludePathPatterns("/cart/{seq}");
    }
}
