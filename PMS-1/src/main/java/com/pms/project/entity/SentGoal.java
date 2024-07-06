package com.pms.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class SentGoal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private String startdate;
	@Column(nullable = false)
	private String enddate;
	@Column(nullable = false)
	private String status;
	@Column(nullable = false, unique = true)
	private long goal_id;

	private int manager_ratings;

	private String manager_feedback;


	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "manager_id")
	private Manager manager;

}
