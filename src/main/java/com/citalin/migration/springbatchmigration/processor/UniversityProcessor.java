package com.citalin.migration.springbatchmigration.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.citalin.migration.springbatchmigration.models.StudentMysql;
import com.citalin.migration.springbatchmigration.models.StudentPostgre;

@Component
public class UniversityProcessor implements ItemProcessor<StudentPostgre, StudentMysql>{

	@Override
	public StudentMysql process(StudentPostgre item) throws Exception {
	//	System.out.println("Inside postgres item : " + item.toString());
		StudentMysql studentMysql = new StudentMysql();
		studentMysql.setId(item.getId());
		studentMysql.setFirstName(item.getFirstName());
		studentMysql.setLastName(item.getLastName());
		studentMysql.setEmail(item.getEmail());
		studentMysql.setActive(Boolean.parseBoolean(item.getActive()));
		studentMysql.setDepartmentId(item.getDepartmentId());		
		return studentMysql;
	}

}
