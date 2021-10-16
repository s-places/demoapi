package com.github.s_places.demoapi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoapiApplication {

	private static Logger logger = LogManager.getLogger("Logger");

	public static void main(String[] args) {
		logger.warn("Demo API started");
		SpringApplication.run(DemoapiApplication.class, args);
	}

}
