package com.ss.demo_service;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoServiceApplication {

    public static void main(String[] args) {
        //SpringApplication.run(DemoServiceApplication.class, args);
        
        new SpringApplicationBuilder(DemoServiceApplication.class)
        .web(WebApplicationType.REACTIVE) // .REACTIVE, .SERVLET
        .run(args);
    }

}
