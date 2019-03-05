package com.infy.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.infy.registration.*")
public class RegistrationAppStarter {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationAppStarter.class, args);

	}

}
