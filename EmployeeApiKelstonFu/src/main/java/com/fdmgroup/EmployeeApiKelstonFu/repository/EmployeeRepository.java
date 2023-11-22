package com.fdmgroup.EmployeeApiKelstonFu.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fdmgroup.EmployeeApiKelstonFu.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	


	Employee findByFirstName(String firstName);

	Employee findByLastName(String lastName);
	
	@Query("SELECT e FROM Employee e WHERE UPPER(CONCAT(e.firstName, ' ', e.lastName)) LIKE UPPER(CONCAT('%',:searchTerm,'%'))")
	Employee findByFirstNameAndLastName(String searchTerm);
		
		

}
