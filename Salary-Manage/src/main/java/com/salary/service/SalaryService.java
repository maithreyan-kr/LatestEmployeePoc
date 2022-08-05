package com.salary.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salary.entity.Salary;
import com.salary.model.SalaryResponse;
import com.salary.repository.SalaryRepository;

@Service
public class SalaryService {
	
	@Autowired
	SalaryRepository salaryRepository;
	
	public String getAllSalaryDetails(String designation) {
		
		Salary salaries = salaryRepository.getAllSalaryByDesignation(designation);
		
			SalaryResponse response = new SalaryResponse();
			
			response.setSalary(salaries.getSalary());
				
		return response.getSalary();
	}

}
