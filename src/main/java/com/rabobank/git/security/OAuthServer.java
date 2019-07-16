package com.rabobank.git.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import com.rabobank.git.service.RaboBankUserService;

/**
 * 
 * @author vinodhr
 *
 */
@Configuration
@EnableAuthorizationServer
public class OAuthServer extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private RaboBankUserService raboBankUserService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private PasswordEncoder pwdEncoder;

	@Value("${spring.rabobank.client}")
	private String clientId;

	@Value("${spring.rabobank.secret}")
	private String secret;

	@Value("${spring.rabobank.granttypes}")
	private String grantTypes;

	@Value("${spring.rabobank.scopes}")
	private String scopes;
	
	@Value("${spring.rabobank.authorities}")
	private String authority;

	@Override
	public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
				.withClient(clientId)
				.secret(pwdEncoder.encode(secret))
				.authorizedGrantTypes(grantTypes)
				.scopes(scopes)
				.authorities(authority)
				.accessTokenValiditySeconds(1000)
				.autoApprove(true);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager)
					.userDetailsService(raboBankUserService);
	}


}
