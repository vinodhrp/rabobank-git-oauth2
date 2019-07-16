package com.rabobank.git.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 
 * @author vinodhr
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**").authorizeRequests().anyRequest().authenticated();
	}
}
