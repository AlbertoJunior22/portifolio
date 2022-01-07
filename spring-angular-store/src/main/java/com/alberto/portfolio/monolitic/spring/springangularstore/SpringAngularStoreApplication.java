package com.alberto.portfolio.monolitic.spring.springangularstore;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAngularStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAngularStoreApplication.class, args);
	}

	@Bean
	public ModelMapper modelMap() {
		return new ModelMapper();
	}
}