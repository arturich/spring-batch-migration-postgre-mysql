package com.citalin.migration.springbatchmigration.models;

public class StudentPostgre {
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private int departmentId;
	
	private boolean isActive;
	
	
	public StudentPostgre()
	{
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	@Override
	public String toString() {
		return "StudentPostgre [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", departmentId=" + departmentId + ", isActive=" + isActive + "]";
	}
	
	

}
