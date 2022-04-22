package com.citalin.migration.springbatchmigration.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.citalin.migration.springbatchmigration.models.StudentMysql;
import com.citalin.migration.springbatchmigration.models.StudentPostgre;
import com.citalin.migration.springbatchmigration.processor.UniversityProcessor;
import com.citalin.migration.springbatchmigration.reader.UniversityReader;
import com.citalin.migration.springbatchmigration.writer.UniversityWriter;

@Configuration
public class MigrationJob {
	
		
	@Autowired
	JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	UniversityReader universityReader;
	
	@Autowired
	UniversityProcessor universityProcessor;
	
	@Autowired
	UniversityWriter universityWriter;
	
	
	@Bean
	public Job universityMigrationJob()
	{
		return jobBuilderFactory.get("migrationJob")
				.incrementer(new RunIdIncrementer())
				.start(migrationStep())
				.build();
	}
	
	
	private Step migrationStep() 
	{
		return stepBuilderFactory.get("migrationStep")
				.<StudentPostgre,StudentMysql>chunk(10)
				.reader(universityReader.studentReader())				
				.processor(universityProcessor)
				.writer(universityWriter.writeToMySqlPreparedStatement())				
				.build();
			
	}
	
	

}
