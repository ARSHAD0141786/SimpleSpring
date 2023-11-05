package com.example.SimpleSprintDemo.controller.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.SimpleSprintDemo.exception.ProductNotFoundException;
import com.example.SimpleSprintDemo.dto.ErrorResponseDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalControllerAdvice {
	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<ErrorResponseDTO> handleProductNotFoundException(Exception exp){
		ErrorResponseDTO error = new ErrorResponseDTO();
		error.setErrorMessage(exp.getMessage());
		error.setErrorCode(404);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
