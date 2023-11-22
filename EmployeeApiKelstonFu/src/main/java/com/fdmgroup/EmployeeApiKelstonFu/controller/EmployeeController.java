package com.fdmgroup.EmployeeApiKelstonFu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.EmployeeApiKelstonFu.exception.EmployeeNotFoundException;
import com.fdmgroup.EmployeeApiKelstonFu.model.Employee;
import com.fdmgroup.EmployeeApiKelstonFu.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;





@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@Operation(summary = "Create a new employee")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Employee created successfully", headers = {
			@Header(name = "location", description = "Uri to access to create employee") }, content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }) })
	@PostMapping
	public ResponseEntity<?> createEmployee(@Valid @RequestBody Employee employee, BindingResult bindingResult){
		
		if (bindingResult.hasErrors()) {
			Map<String, String> errors = new HashMap<>();

			for (FieldError error : bindingResult.getFieldErrors()) {
				errors.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(this.employeeService.createEmployee(employee), HttpStatus.CREATED);
	}
	
	@Operation(summary = "Find All employees")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Find all employees successfully", headers = {
			@Header(name = "location", description = "Uri to access to find employees") }, content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }) })
	@GetMapping
	public ResponseEntity<?> findAllEmployees() {
		return new ResponseEntity<>(this.employeeService.findAllEmployees(), HttpStatus.OK);
	}

	
	@Operation(summary = "Find employee by id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "find an employee successfully", headers = {
			@Header(name = "location", description = "Uri to access to find employee") }, content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }) })
	@GetMapping("/{id}")
	public ResponseEntity<?> findEmployeeById(@PathVariable Long id) {
		Employee employee = this.employeeService.findEmployeeById(id);

		if (employee  == null) {
			return new ResponseEntity<>(
					new EmployeeNotFoundException("The employee with id: " + id + " not found").getMessage(),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@Operation(summary = "Update an employee")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Employee updated successfully", headers = {
			@Header(name = "location", description = "Uri to access to update employee") }, content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }) })
	@PutMapping
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(this.employeeService.updateEmployee(employee), HttpStatus.OK);
	}
	
	@Operation(summary = "Delete an employee")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Employee deleted successfully", headers = {
			@Header(name = "location", description = "Uri to access to delete employee") }, content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }) })
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable Long id) {
		Employee employee = this.employeeService.findEmployeeById(id);

		if (employee == null) {
			return new ResponseEntity<>(
					new EmployeeNotFoundException("The employee with id: " + id + " not found").getMessage(),
					HttpStatus.NOT_FOUND);
		}

		this.employeeService.deleteEmployeeById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@Operation(summary = "Find employee by firstName")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "find an employee successfully", headers = {
			@Header(name = "location", description = "Uri to access to find employee") }, content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }) })
	@GetMapping("/find-by-firstName/{firstName}")
	public ResponseEntity<?> findEmployeeByFirstName(@PathVariable String firstName) {
		Employee employee = this.employeeService.findEmployeeByFirstName(firstName);
		
		if (employee == null) {
			return new ResponseEntity<>(
					new EmployeeNotFoundException("The employee with firstName: " + firstName + " not found").getMessage(),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@Operation(summary = "Find employee by lastName")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "find an employee successfully", headers = {
			@Header(name = "location", description = "Uri to access to find employee") }, content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }) })
	@GetMapping("/find-by-lastName/{lastName}")
	public ResponseEntity<?> findEmployeeByLastName(@PathVariable String lastName) {
		Employee employee = this.employeeService.findEmployeeByLastName(lastName);
		
		if (employee == null) {
			return new ResponseEntity<>(
					new EmployeeNotFoundException("The employee with lastName: " + lastName + " not found").getMessage(),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@Operation(summary = "Find employee by firstName and lastName")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "find an employee successfully", headers = {
			@Header(name = "location", description = "Uri to access to find employee") }, content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }) })
	@GetMapping("/find-by-firstNameAndlastName/{searchTerm}")
	public ResponseEntity<?> findEmployeeByFirstNameLastName(@PathVariable String searchTerm) {
		Employee employee = this.employeeService.findByFirstNameLastName(searchTerm);
		
		if (employee == null) {
			return new ResponseEntity<>(
					new EmployeeNotFoundException("The employee with full name: " + searchTerm + " not found").getMessage(),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
}
