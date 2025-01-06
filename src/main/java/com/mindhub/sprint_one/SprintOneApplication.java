package com.mindhub.sprint_one;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "JI-A-S1",
				version = "1.0.0",
				description = "API Documentation for Sprint 1 Activity Java Immersion 2025 - Accenture."
		)
)
public class SprintOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintOneApplication.class, args);
	}

}
