package com.fdmgroup.EmployeeUIKelstonFu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class EmployeeUiKelstonFuApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeUiKelstonFuApplication.class, args);
	}

}
