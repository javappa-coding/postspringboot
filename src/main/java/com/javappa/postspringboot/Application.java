package com.javappa.postspringboot;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.javappa.postspringboot.service.InitService;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
		
	private InitService initService;
	
	@Autowired
	public Application(InitService initService) {
		this.initService = initService;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}

	@Bean
	public WebMvcConfigurerAdapter forwardToIndex() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				registry.addViewController("/").setViewName("redirect:/index.html");
			}
		};
	}

	@PostConstruct
	public void initData() throws Exception {
		initService.initItems();
	}
}
