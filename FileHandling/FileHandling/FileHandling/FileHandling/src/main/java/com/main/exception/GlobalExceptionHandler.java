package com.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.main.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceHandler(ResourceNotFoundException ex) {
		ApiResponse api = new ApiResponse();
		api.setMessage(ex.getMessage());
		api.setStatus(false);
		return new ResponseEntity<ApiResponse>(api, HttpStatus.NOT_FOUND);

	}

}
