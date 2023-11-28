package com.gaurav.crudrest.exceptions;

public class NoEmployeeFoundException extends RuntimeException{
	
	public NoEmployeeFoundException(String message) {
		super(message);
	}

}
