package com.example.feedback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CentralizedExceptionHandling {
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(IdNotFoundException.class)
	public String idNotFound(IdNotFoundException e) {
		return e.getMessage();
	}

}
