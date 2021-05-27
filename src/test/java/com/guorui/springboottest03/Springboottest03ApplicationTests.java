package com.guorui.springboottest03;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;


@SpringBootTest
class Springboottest03ApplicationTests {


	Logger logger = (Logger) LoggerFactory.getLogger(getClass());

	@Test
	void contextLoads() {
		logger.trace("123");
		logger.info("asd");
		System.out.println("123");
	}

}
