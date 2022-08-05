package com.salary.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "salary")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Salary {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "id")
		private int id;
		
		@Column(name = "designation")
		private String designation;
		
		@Column(name = "salary")
		private String salary;
	
}
