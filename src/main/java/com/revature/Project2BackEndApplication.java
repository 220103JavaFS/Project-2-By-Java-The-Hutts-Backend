package com.revature;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Project2BackEndApplication {

	//Import logger
	private static final Logger mylog = LoggerFactory.getLogger(Project2BackEndApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Project2BackEndApplication.class, args);
	}

}
