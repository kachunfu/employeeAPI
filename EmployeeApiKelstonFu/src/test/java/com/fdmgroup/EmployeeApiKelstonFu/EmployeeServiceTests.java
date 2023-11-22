package com.fdmgroup.EmployeeApiKelstonFu;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fdmgroup.EmployeeApiKelstonFu.model.Employee;
import com.fdmgroup.EmployeeApiKelstonFu.repository.EmployeeRepository;
import com.fdmgroup.EmployeeApiKelstonFu.service.EmployeeService;
import com.fdmgroup.EmployeeApiKelstonFu.service.EmployeeServiceImp;

@SpringBootTest
public class EmployeeServiceTests {
	
//	@Autowired
//	EmployeeService employeeService;
//	
//	@MockBean
//	EmployeeServiceImp mockEmployeeServiceImp;
	
	@Autowired
	EmployeeServiceImp employeeServiceImp;
	
	@MockBean
	Employee mockEmployee;
	
	@MockBean
	List<Employee> mockEmployeeList;
	
	@MockBean
	EmployeeRepository mockEmployeeRepository;
	
	@Test
	void contextLoads() {
	}
	
	
	@Test
	void test_CreateEmployeeReturnedSave(){
		employeeServiceImp.createEmployee(mockEmployee);
		verify(mockEmployeeRepository).save(mockEmployee);
		
	}
	
	@Test
	void test_FindAllEmployeesCallsFindAll() {
	List<Employee> employees = (List<Employee>) employeeServiceImp.findAllEmployees();
	verify(mockEmployeeRepository).findAll();
	
	}
	
	@Test
	void test_FindEmployeeByIdCallsFindById() {
		when(mockEmployee.getId()).thenReturn((long) 1);
		Employee employee = employeeServiceImp.findEmployeeById(mockEmployee.getId());
		verify(mockEmployeeRepository).findById((long)1);
	}
	
	@Test
	void test_UpdateEmployeeReturnedSave() {
		employeeServiceImp.updateEmployee(mockEmployee);
		verify(mockEmployeeRepository).save(mockEmployee);
	}
	
	@Test
	void test_FindEmployeeByFirstNameCallsFindByFirstName() {
		when(mockEmployee.getFirstName()).thenReturn("Sam");
		Employee employee = employeeServiceImp.findEmployeeByFirstName(mockEmployee.getFirstName());
		verify(mockEmployeeRepository).findByFirstName("Sam");
	}
	
	@Test
	void test_FindEmployeeByLastNameCallsFindByLastName() {
		when(mockEmployee.getLastName()).thenReturn("Smith");
		Employee employee = employeeServiceImp.findEmployeeByLastName(mockEmployee.getLastName());
		verify(mockEmployeeRepository).findByLastName("Smith");
	}
	
	@Test
	void test_FindEmployeeByFirstNameAndLastNameCallsFindByLastName() {
		when(mockEmployee.getFirstName()).thenReturn("Sam");
		when(mockEmployee.getLastName()).thenReturn("Smith");
		Employee employee = employeeServiceImp.findByFirstNameLastName(mockEmployee.getFirstName() +" "+ mockEmployee.getLastName());
		verify(mockEmployeeRepository).findByFirstNameAndLastName("Sam Smith");
	}
	
	
	
	
	

	

}
