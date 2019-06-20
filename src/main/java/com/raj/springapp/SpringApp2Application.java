package com.raj.springapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringApp2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringApp2Application.class, args);
	}

}
