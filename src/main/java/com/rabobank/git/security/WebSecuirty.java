package com.rabobank.git.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rabobank.git.service.RaboBankUserService;

/**
 * Authentication of the user 
 * 
 * @author vinodhr
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecuirty extends WebSecurityConfigurerAdapter {

	private Logger logger = LoggerFactory.getLogger(WebSecuirty.class);

	@Autowired
	private RaboBankUserService raboBankUserService;

	/**
	 * User to encode the passwords
	 * 
	 * @return
	 */
	@Bean
	public PasswordEncoder encodePassword() {
		logger.info("BCryptPasswordEncoder Has been Invoked =================> ");
		return new BCryptPasswordEncoder(11);
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		logger.info("authenticationManagerBean Invoked ===============>");
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		logger.info("AuthenticationManagerBuilder Invoked in Web Security===============>");
		auth.userDetailsService(raboBankUserService).passwordEncoder(encodePassword());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("HttpSecurity In Web Security =================> ");
		http	
				.csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
				.antMatchers("/swagger-ui.html/**/**").permitAll()
				.anyRequest().authenticated();
				
	}
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		logger.info("WebSecurity Nothing Configured =================> ");
		super.configure(web);
	}
}
