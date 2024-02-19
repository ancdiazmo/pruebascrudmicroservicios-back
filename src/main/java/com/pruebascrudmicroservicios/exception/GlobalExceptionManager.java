package com.pruebascrudmicroservicios.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionManager extends ResponseEntityExceptionHandler 	{
	
	@ExceptionHandler(value = {SqlException.class})
	public ResponseEntity<String> sqlException (SqlException sqlException) {
		return ResponseEntity.badRequest().body(sqlException.getMessage());
	}
}
