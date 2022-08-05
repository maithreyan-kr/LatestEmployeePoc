package com.employee.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "EmployeeSalary", url = "http://localhost:8019/salary")
public interface FeignUtil {
	
	@GetMapping("/salaryDetails/{designation}")
	String getSalary(@PathVariable(name = "designation")String designation);

}
