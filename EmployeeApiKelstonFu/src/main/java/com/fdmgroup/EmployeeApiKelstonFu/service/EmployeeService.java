package com.fdmgroup.EmployeeApiKelstonFu.service;

import com.fdmgroup.EmployeeApiKelstonFu.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	Employee findEmployeeById(Long id);

	Employee updateEmployee(Employee employee);

	void deleteEmployeeById(Long id);

	Employee findEmployeeByFirstName(String firstName);

	Employee findEmployeeByLastName(String lastName);

	Iterable<Employee> findAllEmployees();

	Employee findByFirstNameLastName(String searchTerm);
}
