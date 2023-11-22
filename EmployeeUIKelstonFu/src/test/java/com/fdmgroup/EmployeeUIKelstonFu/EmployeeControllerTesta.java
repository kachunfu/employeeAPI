package com.fdmgroup.EmployeeUIKelstonFu;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdmgroup.EmployeeUIKelstonFu.controller.EmployeeController;
import com.fdmgroup.EmployeeUIKelstonFu.model.Employee;
import com.fdmgroup.EmployeeUIKelstonFu.request.EmployeeRequestService;



@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTesta {
	
	@Autowired
	EmployeeController employeeController;
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper mapper;

	@MockBean
	EmployeeRequestService mockEmployeeRequestService;
	
	@MockBean
	Employee mockEmployee;
	
	@MockBean
	List<Employee> mockEmployeeList;
	
	@Test
	void contextLoads() {
	}
	
	
	//Correct service methods called for each request
	@Test
	void test_GetrequestToShow_employees_callsFindAllEmployees() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/employees"));
		verify(mockEmployeeRequestService).findAllEmployees();
		
	}
	
	// Correct page displayed for each request
	@Test
	void test_GETrequestToShowForm_index() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
		.andExpect(MockMvcResultMatchers.view().name("index"));
		
	}





	
}
	
	
	

