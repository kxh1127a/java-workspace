package com.example.giftlog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            // cors 에러
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // 모든 경로
                        .allowedOrigins("http://localhost:3000", "http://192.168.0.60:3000")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }

            // 이미지 파일 경로
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                // /uploads/** 요청을 -> 실제 경로로 매핑
                registry.addResourceHandler("/uploads/**")
                        .addResourceLocations("file:/Users/hkb/developer/practice_movie_quote/MovieQuote/uploads/");
            }
        };
    }
}
