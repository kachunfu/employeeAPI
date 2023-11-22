package com.fdmgroup.EmployeeUIWebClientKelstonFu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.EmployeeUIWebClientKelstonFu.model.Employee;
import com.fdmgroup.EmployeeUIWebClientKelstonFu.service.EmployeeService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/webclient/v1/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Flux<Employee> findAllEmployees() {
		return employeeService.findAllEmployees();
	}

}
