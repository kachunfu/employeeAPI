package com.fdmgroup.EmployeeUIWebClientKelstonFu.service;

import java.time.Duration;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fdmgroup.EmployeeUIWebClientKelstonFu.model.Employee;

import reactor.core.publisher.Flux;


@Service
public class EmployeeService {
	
	private WebClient webClient;

	public EmployeeService(WebClient webClient) {
		this.webClient = webClient;
	}
	

	
	public Flux<Employee> findAllEmployees() {
		// @formatter:off
		return this.webClient
				.get()
				.uri("/api/v1/employees")
				.retrieve()
				.bodyToFlux(Employee.class)
				.timeout(Duration.ofMillis(10_000));
		// @formatter:on

	}

}
