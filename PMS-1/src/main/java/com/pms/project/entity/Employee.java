package com.pms.project.entity;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String firstname;
	@Column(nullable = false)
	private String lastname;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String Designation;
	@Column(nullable = false, unique = true)
	private long mobilenumber;
	@Column(nullable = false, unique = true)
	private String email;

	@OneToMany(mappedBy = "employee")
	private List<Goal> goals;
	
	@OneToMany(mappedBy = "employee")
	private List<SentGoal> sentGoals;
	
	@OneToMany(mappedBy = "employee")
	private List<HrViewGoal> hrViewGoals;

}
