package com.saber.camel.spring.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "documentation.swagger")
@Data
@EqualsAndHashCode
@ToString
public class SwaggerConfig {


    private List<SwaggerService> services;

    @EnableConfigurationProperties
    @Component
    @ConfigurationProperties(prefix = "documentation.swagger.services")
    @Data
    @EqualsAndHashCode
    @ToString
    public static class SwaggerService {

        private String name;
        private String url;
        private String version;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        // Allow anyone and anything access. Probably ok for Swagger spec
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        source.registerCorsConfiguration("/swagger-ui.html*", config);
        return new CorsFilter(source);
    }

}
