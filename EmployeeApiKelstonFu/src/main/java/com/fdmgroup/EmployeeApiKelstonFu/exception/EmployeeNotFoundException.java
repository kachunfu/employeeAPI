package com.fdmgroup.EmployeeApiKelstonFu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6508227805904346206L;

	public EmployeeNotFoundException(String msg) {
		super(msg);
	}
}
