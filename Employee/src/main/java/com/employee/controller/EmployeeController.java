package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.model.EmployeeRequest;
import com.employee.model.EmployeeResponse;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PutMapping(value="/addEmployee/")
	public String addEmployee(@RequestBody EmployeeRequest employeeRequest) {
		employeeService.addEmployee(employeeRequest);
		return ("employee added successfully");
	}

	@DeleteMapping("/deleteEmploee/{employeeId}")
	public String deleteEmployee(@ModelAttribute("employeeId") String employeeId) {
		employeeService.deleteEmployee(employeeId);
		return ("employee with ID " + employeeId + " deleted successfully");
	}

	@GetMapping("/allEmployee/")
	public List<Employee> getAllEmployeeDetails() {
		return employeeService.getAllEmployeeDetails();
	}
	
	@GetMapping("/employeeDetails/{employeeId}")
	public EmployeeResponse getEmployeeDetailsByEmployeeId(@PathVariable(name = "employeeId")String employeeId) {
		return employeeService.getEmployeeDetails(employeeId);
	}
	
	
}
