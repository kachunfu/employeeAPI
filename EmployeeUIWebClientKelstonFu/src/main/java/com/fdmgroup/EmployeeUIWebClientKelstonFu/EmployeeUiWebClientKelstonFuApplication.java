package com.fdmgroup.EmployeeUIWebClientKelstonFu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;


@EnableAutoConfiguration(exclude = {WebMvcAutoConfiguration.class })
@SpringBootApplication
public class EmployeeUiWebClientKelstonFuApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeUiWebClientKelstonFuApplication.class, args);
	}

}
