package com.employee.service;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.openMocks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.employee.client.FeignUtil;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

public class EmployeeServiceTest {
	
	@Mock
	FeignUtil salaryUtil;
	
	@Mock
	EmployeeRepository employeeRepository;
	
	@InjectMocks
	EmployeeService employeeService;
	
	@BeforeEach
	public void init( ) {
		openMocks(this);
	}
	
	@Test
	public void getAllEmployeeDetails() throws ParseException {
		when(employeeRepository.findAll()).thenReturn(formEmployee());
		List<Employee> employeeList = employeeService.getAllEmployeeDetails();
		List<Employee> employee = populateEmployee(employeeList); 
		assertEquals(1L, employee.get(0).getId());
		assertEquals("maithreyan", employee.get(0).getFirstName());
		assertEquals("ramalingam", employee.get(0).getLastName());
		assertEquals("48367", employee.get(0).getEmployeeId());
//		assertEquals("1998-10-15", employee.get(0).getDob());
		assertEquals(24, employee.get(0).getAge());
		assertEquals(1, employee.get(0).getExperience());
		assertEquals("associate", employee.get(0).getDesignation());
	}



	private List<Employee> populateEmployee(List<Employee> employeeList) {

		List<Employee> employees = new ArrayList<>();
		employeeList.stream().forEach(it -> {
			Employee employee = new Employee();
			
			employee.setFirstName(it.getFirstName());
			employee.setId(it.getId());
			employee.setLastName(it.getLastName());
			employee.setDob(it.getDob());
			employee.setAge(it.getAge());
			employee.setExperience(it.getExperience());
			employee.setDesignation(it.getDesignation());
			employee.setEmployeeId(it.getEmployeeId());
			
			employees.add(employee);
		});
		return employees;
	}



	private List<Employee> formEmployee() throws ParseException {
		
		List<Employee> employeeList = new ArrayList<>();
		
		Employee employee = new Employee();
		
		employee.setId(1L);
		employee.setFirstName("maithreyan");
		employee.setLastName("ramalingam");
		employee.setEmployeeId("48367");
//		Date date = new SimpleDateFormat("yyyyMMdd").parse("19981015");
//		employee.setDob(date);
		employee.setAge(24);
		employee.setExperience(1);
		employee.setDesignation("associate");
		
		employeeList.add(employee);
		 
		return employeeList;
	}

}
