package com.rabobank.git.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabobank.git.constant.APIConstant;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * Provides Information and Technical Specs for the Rest Controllers(APIs) created.
 * Easy to understand the APIs and for integration purpose.
 * 
 * @author vinodhr
 *
 */
@EnableSwagger2
@Configuration
public class APIConfig {

	/**
	 * Creating Instance of Docket for generation of APIs document
	 * 
	 * @return Docket
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(APIConstant.BASE_PACK))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(createApiInfo());
	}

	/**
	 * Generates the Basic Information of API Creator
	 * 
	 * @return ApiInfo
	 */
	private ApiInfo createApiInfo() {
		return new ApiInfo(
	    		APIConstant.API_TITLE,
	            APIConstant.API_DESC,
	            APIConstant.VERSION,
	            APIConstant.TERMS_URL,
	            new Contact(APIConstant.USR_NAME, 
	            			APIConstant.USR_GIT,
	            			APIConstant.USR_EMAIL),
	            APIConstant.LICENSE,
	            APIConstant.LICENSE_URL,
	            Collections.emptyList()
	    );
	}

}
