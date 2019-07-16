package com.rabobank.git.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rabobank.git.util.CustomMessage;

import feign.FeignException;

/**
 * Handler handles all the global exception thrown by the controller with respective of the
 * Exception type and corresponding message custom message will be returned to the user.
 * 
 * @author vinodhr
 *
 */
@ControllerAdvice
@Component
public class RaboExceptionHandler extends ResponseEntityExceptionHandler {

	public Logger logger = LoggerFactory.getLogger(RaboExceptionHandler.class);

	/**
	 * Handles all FeignException thrown by Git API.
	 * 
	 * @param exception
	 * @param request
	 * @return ResponseEntity
	 */
	@ExceptionHandler(value = { FeignException.class })
	public ResponseEntity<?> handleFeignExceptions(Exception exception, WebRequest request) {
		logger.error("Excpetion thrown due to Feign Client....  : ", exception.getMessage());
		CustomMessage apiCustomMessage = new CustomMessage(HttpStatus.BAD_REQUEST, "Excpetion thrown due to Feign Client" + exception.getMessage());
		return new ResponseEntity<CustomMessage>(apiCustomMessage, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handles all type of Exception thrown by either Git or Restcontroller.
	 * 
	 * @param exception
	 * @param request
	 * @return ResponseEntity
	 */
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<?> handleAllExceptions(Exception exception, WebRequest request) {
		logger.error("Something went Wrong : ", exception.getMessage());
		CustomMessage apiCustomMessage = new CustomMessage(HttpStatus.BAD_REQUEST, "Something went Wrong :" + exception.getMessage());
		return new ResponseEntity<CustomMessage>(apiCustomMessage, HttpStatus.BAD_REQUEST);
	}

}
