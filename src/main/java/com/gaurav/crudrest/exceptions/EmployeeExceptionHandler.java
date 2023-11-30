package com.gaurav.crudrest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> noEmployeeFoundException(NoEmployeeFoundException exp){
		
		EmployeeErrorResponse response = new EmployeeErrorResponse();
		response.setCode(HttpStatus.NOT_FOUND.value());
		response.setMessage(exp.getMessage());
		response.setTimestamp(String.valueOf(System.currentTimeMillis()));
		
		return new ResponseEntity<EmployeeErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> genericException(Exception exp){
		
		EmployeeErrorResponse response = new EmployeeErrorResponse();
		response.setCode(HttpStatus.BAD_REQUEST.value());
		response.setMessage("Invalid inputs provided. Please try again later...");
		response.setTimestamp(String.valueOf(System.currentTimeMillis()));
		
		return new ResponseEntity<EmployeeErrorResponse>(response, HttpStatus.BAD_REQUEST);
	}

}
