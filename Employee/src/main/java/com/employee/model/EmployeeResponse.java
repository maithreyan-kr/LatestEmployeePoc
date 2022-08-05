package com.employee.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponse {
	
	private String employeeId;

	private String employeeFullName;
	
	private String dob;

	private int age;

	private int experience;

	private String designation;

	private String salary;

}
