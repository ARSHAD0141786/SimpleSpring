package com.example.EcommerceProductService.controller.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.EcommerceProductService.dto.ErrorResponseDTO;
import com.example.EcommerceProductService.exception.ProductNotFoundException;

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
