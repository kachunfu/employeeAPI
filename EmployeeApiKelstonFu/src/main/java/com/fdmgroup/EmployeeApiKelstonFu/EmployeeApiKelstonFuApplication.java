package com.fdmgroup.EmployeeApiKelstonFu;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;




@EnableEurekaClient
@SpringBootApplication
public class EmployeeApiKelstonFuApplication{

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApiKelstonFuApplication.class, args);
	}
	
	
	

}
