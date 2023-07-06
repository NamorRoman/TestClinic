package com.example.gateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("clinic-service", r -> r.path("/api/clinic/**")
                        //   .filters(f -> f.filter(filter))
                        .filters(f -> f.rewritePath("/api/clinic/(?<remains>.*)", "/${remains}")
                                .addRequestHeader("X-book-Header", "book-service-header"))
                        .uri("lb://clinic/"))
                .build();
    }

//    @Bean
//    RouteLocator gatewayRouteEx(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("book-service", r -> r.path("/api/books/**")
//                        //   .filters(f -> f.filter(filter))
//                        .filters(f -> f.rewritePath("/api/books/(?<remains>.*)", "/${remains}")
//                                .addRequestHeader("X-book-Header", "book-service-header"))
//                        .uri("lb://book-service/"))
//                .build();
//    }
}

