package com.example.SimpleSprintDemo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDTO {
	private String errorMessage;
	private int errorCode;
}
