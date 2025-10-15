package com.projectsda.hello_ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HelloAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloAiApplication.class, args);
	}

}
