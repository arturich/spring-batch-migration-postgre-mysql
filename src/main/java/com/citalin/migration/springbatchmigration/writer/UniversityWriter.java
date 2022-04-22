package com.citalin.migration.springbatchmigration.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.citalin.migration.springbatchmigration.models.StudentMysql;

@Component
public class UniversityWriter implements ItemWriter<StudentMysql>{

	@Override
	public void write(List<? extends StudentMysql> items) throws Exception {
		System.out.println("Inside item writer");
		
		items.stream()
		.forEach(System.out::println);
		
	}

}