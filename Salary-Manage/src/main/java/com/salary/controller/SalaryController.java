package com.salary.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salary.service.SalaryService;

@RestController
@RequestMapping("/salary")
public class SalaryController {
	
	@Autowired
	SalaryService salaryService;
	
	@GetMapping("/salaryDetails/{designation}")
	public String getSalary(@PathVariable(name = "designation")String designation) {
		return salaryService.getAllSalaryDetails(designation);
	}

}
