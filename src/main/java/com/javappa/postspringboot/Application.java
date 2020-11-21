package com.javappa.postspringboot;

import com.javappa.postspringboot.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    private InitService initService;

    @Autowired
    public Application(InitService initService) {
        this.initService = initService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    @PostConstruct
    public void initData() throws Exception {
        initService.initItems();
    }
}
