package com.medi.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.medi.web.model.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Throwable ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
		errorResponse.setErrorMessage(ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ErrorResponse> handleException(BusinessException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(ex.getErrorResponseCode());
		errorResponse.setErrorMessage(ex.getErrorResponseMessage());
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(errorResponse);
	}
}
