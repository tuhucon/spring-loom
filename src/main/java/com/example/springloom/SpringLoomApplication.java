package com.example.springloom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatProtocolHandlerCustomizer;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.Executors;

@SpringBootApplication
public class SpringLoomApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringLoomApplication.class, args);
    }

//    @Bean
//    public TomcatProtocolHandlerCustomizer<?> protocolHandlerCustomizer() {
//        return protocolHandler -> {
//            protocolHandler.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
//        };
//    }
}