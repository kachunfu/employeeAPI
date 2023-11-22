package com.fdmgroup.EmployeeUIKelstonFu.model;

import java.math.BigDecimal;

public class Employee {
	
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private BigDecimal salary;
	
	private String state;
	
	private String country;

	public Employee(String firstName, String lastName, BigDecimal salary, String state, String country) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.state = state;
		this.country = country;
	}

	public Long getId() {
		return id;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	

}
