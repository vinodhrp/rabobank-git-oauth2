package com.rabobank.git.util;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Handle the custom messages in case of any success or error occurred
 * 
 * @author vinodhr
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomMessage {

	private HttpStatus httpStatus;

	private String message;
}
