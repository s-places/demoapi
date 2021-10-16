package com.github.s_places.demoapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@WebAppConfiguration
class DemoapiApplicationTests {

	private final String HOST = "http://localhost:8080";
	private Logger logger = LogManager.getLogger("Logger");
	private Person person = new Person(999, "Petr", "Petrov", "Petrovich", "+7900000000", "test@test2.test.com");

	private TestRestTemplate testRestTemplate() {
		var restTemplate = new RestTemplateBuilder().rootUri(HOST);
		return new TestRestTemplate(restTemplate);
	}

	@Test
	void restResponseIsValid() throws Exception {

		var readResponse = testRestTemplate().getForEntity("/persons/1", Person.class);
		logger.warn(readResponse.toString());
		assertEquals(200, readResponse.getStatusCodeValue());
	}

	@Test
	void restCreateDeleteIsValid() throws Exception {

		var createResponse = testRestTemplate().postForEntity("/persons", person, Person.class);
		logger.warn(createResponse.toString());
		assertEquals(201, createResponse.getStatusCodeValue());

		testRestTemplate().delete("/persons/999");
		var readResponse = testRestTemplate().getForEntity("/persons/999", Person.class);
		logger.warn(readResponse.toString());
		assertEquals(404, readResponse.getStatusCodeValue());

	}

}
