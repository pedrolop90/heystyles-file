package com.heystyles.file.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "com.heystyles.file.api.async",
        "com.heystyles.file.api.config",
        "com.heystyles.file.api.controller",
        "com.heystyles.file.api.converter",
        "com.heystyles.file.api.dao",
        "com.heystyles.file.api.entity",
        "com.heystyles.file.api.service",
        "com.heystyles.file.api.exception",
        "com.heystyles.file.api.http",
        "com.heystyles.file.api.message",
        "com.heystyles.file.api.service",
        "com.heystyles.file.api.validator",
})
@SpringBootApplication
public class FileApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FileApp.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(FileApp.class, args);
    }

}
