package com.citalin.migration.springbatchmigration.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.citalin.migration.springbatchmigration.models.StudentPostgre;

@Component
public class UniversityReader {
	
	@Autowired
	@Qualifier("universityDataOrigin")
	DataSource universityDataOrigin;
	
	public JdbcCursorItemReader<StudentPostgre> studentReader()
	{
		JdbcCursorItemReader<StudentPostgre> studentReader =
				new JdbcCursorItemReader<StudentPostgre>();
		
		studentReader.setDataSource(universityDataOrigin);
		
		studentReader.setSql("SELECT id, first_name as firstName, last_name as lastName, email, dept_id as departmentId, is_active as isActive \r\n"
				+ "	FROM public.student;");
		
		studentReader.setRowMapper(new BeanPropertyRowMapper<StudentPostgre>() {
			{
				setMappedClass(StudentPostgre.class);
			}
		});
		
		return studentReader;
	}

}
