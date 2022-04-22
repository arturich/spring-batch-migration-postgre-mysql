package com.citalin.migration.springbatchmigration.writer;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
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
	
	
	@Bean
	public JdbcBatchItemWriter<StudentMysql> writeToMySql()
	{
		JdbcBatchItemWriter<StudentMysql> jdbcBatchItemWriter =
				new JdbcBatchItemWriter<StudentMysql>();
		
		jdbcBatchItemWriter.setDataSource(universityDataDestiny);
		
		jdbcBatchItemWriter.setSql(
				"INSERT INTO student(id,first_name,last_name,email,dept_id,is_active)"
				+ " VALUES(:id,:firstName,:lastName,:email,:departmentId,:active)");
		
		jdbcBatchItemWriter.setItemSqlParameterSourceProvider(
				new BeanPropertyItemSqlParameterSourceProvider<StudentMysql>()
				);
		
		return jdbcBatchItemWriter;
	}
	
	@Bean
	public JdbcBatchItemWriter<StudentMysql> writeToMySqlPreparedStatement()
	{
		JdbcBatchItemWriter<StudentMysql> jdbcBatchItemWriter =
				new JdbcBatchItemWriter<StudentMysql>();
		
		jdbcBatchItemWriter.setDataSource(universityDataDestiny);
		
		jdbcBatchItemWriter.setSql(
				"INSERT INTO student(id,first_name,last_name,email,dept_id,is_active)"
				+ "VALUES(?,?,?,?,?,?)");
		
		
		jdbcBatchItemWriter.setItemPreparedStatementSetter(
				new ItemPreparedStatementSetter<StudentMysql>() {
					
					@Override
					public void setValues(StudentMysql item, PreparedStatement ps) throws SQLException {
						
						ps.setLong(1, item.getId());
						ps.setString(2, item.getFirstName());
						ps.setString(3, item.getLastName());
						ps.setString(4, item.getEmail());
						ps.setLong(5, item.getDepartmentId());
						ps.setBoolean(6, item.getActive());
						
					}
				});
		
		
		return jdbcBatchItemWriter;
	}
	
	
	@Autowired
	@Qualifier("universityDataDestiny")
	DataSource universityDataDestiny;

}