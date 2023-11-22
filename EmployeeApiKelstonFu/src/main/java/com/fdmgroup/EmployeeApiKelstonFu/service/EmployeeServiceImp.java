package com.fdmgroup.EmployeeApiKelstonFu.service;

import org.springframework.stereotype.Service;

import com.fdmgroup.EmployeeApiKelstonFu.model.Employee;
import com.fdmgroup.EmployeeApiKelstonFu.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImp(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public Employee createEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}
	
	@Override
	public Iterable<Employee> findAllEmployees() {
		return this.employeeRepository.findAll();
	}
	
	@Override
	public Employee findEmployeeById(Long id) {
		return this.employeeRepository.findById(id).orElse(null);
	}
	
	@Override
	public Employee updateEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}
	
	@Override
	public void deleteEmployeeById(Long id) {
		this.employeeRepository.deleteById(id);
	}
	
	@Override
	public Employee findEmployeeByFirstName(String firstName) {
		return this.employeeRepository.findByFirstName(firstName);
	}
	
	@Override
	public Employee findEmployeeByLastName(String lastName) {
		return this.employeeRepository.findByLastName(lastName);
	}


	@Override
	public Employee findByFirstNameLastName(String searchTerm) {

		return this.employeeRepository.findByFirstNameAndLastName(searchTerm);
	}
}
