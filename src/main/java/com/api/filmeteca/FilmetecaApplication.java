package com.api.filmeteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @Configuration
// @EntityScan("com.api.filmeteca.model")
// @ComponentScan("com.api.filmeteca.repository")
// @ComponentScan({ "com.api.filmeteca.controller" })
// @EntityScan("com.api.filmeteca.model")
// @EnableJpaRepositories("com.api.filmeteca.repository")
@EnableAutoConfiguration
public class FilmetecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmetecaApplication.class, args);
	}

}
