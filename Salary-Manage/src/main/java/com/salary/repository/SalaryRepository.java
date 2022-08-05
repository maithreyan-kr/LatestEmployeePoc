package com.salary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salary.entity.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Integer> {
	
	public Salary getAllSalaryByDesignation(String designation);

}
