package com.rabobank.git.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rabobank.git.entity.RaboBankUser;

/**
 * Implementation of Mock Rabobank User Service
 * 
 * @author vinodhr
 *
 */
@Service
public class RaboBankUserService implements UserDetailsService {

	Logger logger = LoggerFactory.getLogger(RaboBankUserService.class);
	
	@Value("${spring.rabobank.user.id}")
	private Long userId;

	@Value("${spring.rabobank.user.name}")
	private String userName;

	@Value("${spring.rabobank.user.password}")
	private String password;

	@Value("$(spring.rabobank.user.role)")
	private String role;
	
	@Autowired
	private PasswordEncoder pwdEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		RaboBankUser user = new RaboBankUser();
		user.setPassword(pwdEncoder.encode(password));
		user.setUserName(userName);
		user.setUserId(userId);
		user.setRole(role);
		logger.info("loadUserByUsername Invoked in Service Layer===============>" + userName);
		return new User(user.getUsername(), user.getPassword(), user.getAuthorities());
	}

}
