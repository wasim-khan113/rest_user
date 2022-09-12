 package com.rest.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity blogNotFoundException(NumberFormatException numberFormatException) {
		return new ResponseEntity("NumberFormatException", HttpStatus.BAD_REQUEST);
	}
}
