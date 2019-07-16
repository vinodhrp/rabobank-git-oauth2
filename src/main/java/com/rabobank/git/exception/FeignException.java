package com.rabobank.git.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Custom FeignException
 * 
 * @author vinodhr
 *
 */
@AllArgsConstructor
@Getter
@Setter
public class FeignException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errorMessage;
}
