package com.citalin.migration.springbatchmigration.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.citalin.migration.springbatchmigration.models.StudentMysql;
import com.citalin.migration.springbatchmigration.models.StudentPostgre;

@Component
public class UniversityProcessor implements ItemProcessor<StudentPostgre, StudentMysql>{

	@Override
	public StudentMysql process(StudentPostgre item) throws Exception {
		System.out.println("Inside itemp processor");
		StudentMysql studentMysql = new StudentMysql();
		studentMysql.setId(item.getId());
		studentMysql.setFirstName(item.getFirstName());
		studentMysql.setLastName(item.getLastName());
		studentMysql.setEmail(item.getEmail());
		studentMysql.setActive(item.isActive());
		studentMysql.setDepartmentId(item.getDepartmentId());		
		return studentMysql;
	}

}
