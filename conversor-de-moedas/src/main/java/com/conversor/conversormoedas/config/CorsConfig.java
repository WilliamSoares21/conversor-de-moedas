package com.conversor.conversormoedas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
         registry.addMapping("/**")  // Aplica CORS em todas as rotas
             .allowedOrigins("http://localhost:5173", "http://localhost:5174", "http://localhost:3000")  // Permite Vite e React
             .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
             .allowedHeaders("*")
             .allowCredentials(true);
    }
}

