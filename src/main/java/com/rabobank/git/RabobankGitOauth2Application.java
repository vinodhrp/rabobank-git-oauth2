package com.rabobank.git;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * Init of Spring App, enables Feign and Security
 * 
 * @author vinodhr
 *
 */
@SpringBootApplication
@EnableFeignClients
@EnableWebSecurity
public class RabobankGitOauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(RabobankGitOauth2Application.class, args);
	}

}
