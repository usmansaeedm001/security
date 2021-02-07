package com.mus.securedwebapplicationdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SecureWebAppDemoApplication {



	public static void main(String[] args) {
		SpringApplication.run(SecureWebAppDemoApplication.class, args);
	}

	@PostConstruct
	public void init(){

	}

}
