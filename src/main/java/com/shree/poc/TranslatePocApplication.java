package com.shree.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.shree.poc.repositories") 
@EntityScan("com.shree.poc.entities")
@SpringBootApplication
public class TranslatePocApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranslatePocApplication.class, args);
	}

}
