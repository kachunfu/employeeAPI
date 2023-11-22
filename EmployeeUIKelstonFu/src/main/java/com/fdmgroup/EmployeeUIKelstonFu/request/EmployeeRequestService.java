package com.fdmgroup.EmployeeUIKelstonFu.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fdmgroup.EmployeeUIKelstonFu.model.Employee;

@FeignClient(value = "employee-api-kelston-fu", path = "/api/v1/employees", url = "http://localhost:8088")
public interface EmployeeRequestService {

	@PostMapping
	Object createEmployee(@RequestBody Object employee);

	@DeleteMapping("/{id}")
	void deleteEmployeeById(@PathVariable("id") Long id);

	@GetMapping
	Iterable<Object>findAllEmployees();
	
	@GetMapping("/{id}")
	Employee findEmployeeById(@PathVariable("id") Long id);
	
	@PutMapping
	Object updateEmployee(@RequestBody Object employee);
	
}
