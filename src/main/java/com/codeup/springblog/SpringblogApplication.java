package com.codeup.springblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.testng.annotations.Test;

@SpringBootApplication
public class SpringblogApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringblogApplication.class, args);
	}
	@Test
	void contextLoads() {
	}


}
