package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.client.FeignUtil;
import com.employee.entity.Employee;
import com.employee.exception.ResourceNotFoundException;
import com.employee.model.EmployeeRequest;
import com.employee.model.EmployeeResponse;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	FeignUtil salaryUtil;
	
	public void addEmployee(EmployeeRequest employeeRequest ) {
		
		Employee employee = new Employee();
		
		employee.setEmployeeId(employeeRequest.getEmployeeId());
		employee.setFirstName(employeeRequest.getFirstName());
		employee.setLastName(employeeRequest.getLastName());
		employee.setDob(employeeRequest.getDob());
		employee.setAge(employeeRequest.getAge());
		employee.setExperience(employeeRequest.getExperience());
		employee.setDesignation(employeeRequest.getDesignation());
		
		employeeRepository.save(employee);
		
	}
	
	public List<Employee> getAllEmployeeDetails() {
		
		List<Employee> employees = employeeRepository.findAll();
		
		return employees;
		
	}
	
	public void deleteEmployee(String employeeId) {
		
		Employee employee = employeeRepository.getEmployeeByEmployeeId(employeeId);
		
		employeeRepository.delete(employee);
		
	}
	
	public EmployeeResponse getEmployeeDetails(String employeeId) {
		
		Employee employee = employeeRepository.getEmployeeByEmployeeId(employeeId);
		
		EmployeeResponse employeeResponse = new EmployeeResponse();
		
		if (employee==null) {
			
			throw new ResourceNotFoundException("no detils found for employee with Employee Id : " + employeeId);
			
		}
		
		employeeResponse.setEmployeeId(employeeId);
		employeeResponse.setEmployeeFullName(employee.getFirstName() + " " + employee.getLastName());
		employeeResponse.setDob(employee.getDob().toString());
		employeeResponse.setAge(employee.getAge());
		employeeResponse.setExperience(employee.getExperience());
		employeeResponse.setDesignation(employee.getDesignation());
		String salary = salaryUtil.getSalary(employeeResponse.getDesignation());
		employeeResponse.setSalary(salary);
		
		return employeeResponse;
		
	}

}
