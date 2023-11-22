package com.fdmgroup.EmployeeApiKelstonFu;


import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdmgroup.EmployeeApiKelstonFu.controller.EmployeeController;
import com.fdmgroup.EmployeeApiKelstonFu.model.Employee;
import com.fdmgroup.EmployeeApiKelstonFu.service.EmployeeServiceImp;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTests {
	
	@Autowired
	EmployeeController employeeController;
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	EmployeeServiceImp mockEmployeeServiceImp;
	
	@MockBean
	Employee mockEmployee;
	
	@MockBean
	List<Employee> mockEmployeeList;
	
	@Test
	void contextLoads() {
	}
	
	
	@Test
	void test_DeleterequestToCallDeleteEmployeeByIdReturned_NotFound() throws Exception{
		 long id = 1L;
		 doNothing().when(mockEmployeeServiceImp).deleteEmployeeById(id);
		 mockMvc.perform(delete("/api/v1/employees/{id}", id))
		 		.andExpect(status().isNotFound())
		 		.andDo(print());
	}
	
	@Test
	void test_PostrequestToCallCreateEmployee() throws Exception{
		Employee employee = new Employee();
		employee.setId((long) 1);
		employee.setFirstName("Sam");
		employee.setLastName("Smith");
		employee.setSalary(new BigDecimal (100000));
		employee.setState("Hampshire");
		employee.setCountry("UK");

		mockMvc.perform(post("/api/v1/employees").contentType(MediaType.APPLICATION_JSON)
		        .content(objectMapper.writeValueAsString(employee)))
		        .andExpect(status().isCreated())
		        .andDo(print());
	}
	
	@Test
	void test_GetrequestToCallFindEmployeeById() throws Exception{
		
		long id = 1L;
		Employee employee = new Employee();
		employee.setId((long) 1);
		employee.setFirstName("Sam");
		employee.setLastName("Smith");
		employee.setSalary(new BigDecimal (100000));
		employee.setState("Hampshire");
		employee.setCountry("UK");
		
		when(mockEmployeeServiceImp.findEmployeeById(id)).thenReturn(employee);
		mockMvc.perform(get("/api/v1/employees/{id}", id)).andExpect(status().isOk())
        .andExpect((ResultMatcher) jsonPath("$.id").value(id))
        .andExpect((ResultMatcher) jsonPath("$.firstName").value(employee.getFirstName()))
        .andExpect((ResultMatcher) jsonPath("$.lastName").value(employee.getLastName()))
        .andExpect((ResultMatcher) jsonPath("$.salary").value(employee.getSalary()))
        .andExpect((ResultMatcher) jsonPath("$.state").value(employee.getState()))
        .andExpect((ResultMatcher) jsonPath("$.country").value(employee.getCountry()))
        .andDo(print());
		
	}
	
	@Test
	void test_GetrequestToReturnAllEmployees() throws Exception{
		Employee employee1 = new Employee();
		employee1.setFirstName("Sam");
		employee1.setLastName("Smith");
		employee1.setSalary(new BigDecimal (100000));
		employee1.setState("Hampshire");
		employee1.setCountry("UK");
		
		Employee employee2 = new Employee();
		employee1.setFirstName("John");
		employee1.setLastName("Smith");
		employee1.setSalary(new BigDecimal (200000));
		employee1.setState("Tokyo");
		employee1.setCountry("Japan");
		List<Employee> employees = new ArrayList<>(Arrays.asList(employee1, employee2));
		
		when(mockEmployeeServiceImp.findAllEmployees()).thenReturn(employees);
		mockMvc.perform(get("/api/employees"))
			.andExpect(status().isOk())
			.andExpect((ResultMatcher) jsonPath("$.size()").value(employees.size()))
			.andDo(print());
	}


	
	
}
