package com.birang.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class Application {

	public static final String APPLICATION_LOCATIONS = "spring.config.location="
			+ "classpath:application.yml,"
			+ "/app/config/spring-webservice/real-application.yml"; //EC2 경로
			//+ "/Users/hjlee/app/config/spring-webservice/real-application.yml"; //로컬 경로

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class)
				.properties(APPLICATION_LOCATIONS)
				.run(args);
	}

	/*public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}*/
}
