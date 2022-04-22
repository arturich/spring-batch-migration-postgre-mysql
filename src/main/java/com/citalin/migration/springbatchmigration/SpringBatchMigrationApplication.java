package com.citalin.migration.springbatchmigration;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class SpringBatchMigrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchMigrationApplication.class, args);
	}

}
