package com.employee.model;

import java.util.Date;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {
	
	private String employeeId;
	
	private String firstName;
	
	private String lastName;
	
	private Date dob;
	
	private int age;
	
	private int experience;
	
	private String designation;

}
