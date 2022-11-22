package com.calisto.spring.rest_api;

import com.calisto.spring.rest_api.controller.UserController;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiApplication {
	private static final Logger log = Logger.getLogger(RestApiApplication.class);

	public static void main(String[] args) {
		log.info("запуск программы");
		SpringApplication.run(RestApiApplication.class, args);
	}

}
