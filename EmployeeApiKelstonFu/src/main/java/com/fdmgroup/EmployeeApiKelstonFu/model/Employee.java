package com.fdmgroup.EmployeeApiKelstonFu.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Employee {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		
		@NotBlank(message = "First name is a required field.")
		@Size(min = 2, max = 100, message = "First name must be between 2 to 100 characters long.")
		@Column(nullable = false, name = "employee_first_name", updatable = true) 
		private String firstName;
		
		@NotBlank(message = "Last name is a required field.")
		@Size(min = 2, max = 100, message = "Last name must be between 2 to 100 characters long.")
		@Column(nullable = false, name = "employee_last_name", updatable = true) 
		private String lastName;
		
		
		@DecimalMin(value = "100", inclusive = false, message = "Salary must be greater than 100.")
		@Column(nullable = false, updatable = true)
		private BigDecimal salary;
		
		@NotBlank(message = "State is a required field.")
		@Column(nullable = false, updatable = false)
		private String state;
		
		@NotBlank(message = "Country is a required field.")
		@Column(nullable = false, updatable = false)
		private String country;
		
		public String getFirstName() {
			return firstName;
		}

		public void setFristName(String firstName) {
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

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}





	


	
		
		
		
}
