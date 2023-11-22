package com.fdmgroup.EmployeeUIKelstonFu.controller;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.fdmgroup.EmployeeUIKelstonFu.model.Employee;
import com.fdmgroup.EmployeeUIKelstonFu.request.EmployeeRequestService;


@Controller
public class EmployeeController {

	private EmployeeRequestService employeeRequestService;

	public EmployeeController(EmployeeRequestService employeeRequestService) {
		this.employeeRequestService = employeeRequestService;
	}
	
	  @GetMapping
	  public String showForm() {
	    return "index";
	  }
	
	  
	  @PostMapping("/")
	  public String saveEmployee(
	    @RequestParam("firstName") String firstName,
	    @RequestParam("lastName") String lastName,
	    @RequestParam("salary") BigDecimal salary,
	    @RequestParam("state") String state,
	    @RequestParam("country") String country
	  ) {
	    Object object = new Employee(firstName, lastName, salary, state, country);
	    employeeRequestService.createEmployee(object);
	    return "index";
	  }
	  
	    
	    
		@GetMapping("/{id}")
	  public Employee findEmployeeById(@PathVariable Long id) {
		return employeeRequestService.findEmployeeById(id) ;
	  }
	
		//Show all employees in a table
	  @GetMapping("/employees")
	  public String showAllEmployees(Model model) {
		 model.addAttribute("employees", employeeRequestService.findAllEmployees());
		  return "employees";
	  }
	  
	  //Direct to a form to let user update user
	  @GetMapping("/employees/update/{id}")
	  public String updateEmployeeForm(@PathVariable Long id, Model model) {
		  model.addAttribute("employee", employeeRequestService.findEmployeeById(id)); 
		 return "update_employee"; 
	  }
	  
	  //Update user and redirect to the previous page
	  @PostMapping("/employees/{id}")
	  public String updateEmployee(@PathVariable Long id ,
			  	@ModelAttribute("employee") Employee employee, 
			  	Model model) {
		  Employee existingEmployee = employeeRequestService.findEmployeeById(id);
		  existingEmployee.setFirstName(employee.getFirstName());
		  existingEmployee.setLastName(employee.getLastName());
		  existingEmployee.setSalary(employee.getSalary());

		  employeeRequestService.updateEmployee(existingEmployee);
		 
		  return "redirect:/employees"; 
	  }
	  
	  
	  
	  @DeleteMapping("/{id}")
	  public String deleteEmployeeById(@RequestParam("id") Long id){
		  employeeRequestService.deleteEmployeeById(id);
		  return "index";
	  }
	 	  

	  
	

}
