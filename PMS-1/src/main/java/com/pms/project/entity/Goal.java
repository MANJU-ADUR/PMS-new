package com.pms.project.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob; // Import Lob annotation
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Goal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String title;

	@Lob // Use Lob annotation for large objects
	@Column(nullable = false, length = 5000) // Set length explicitly for CLOB
	private String description;

	@Column(nullable = false)
	private String startdate;

	@Column(nullable = false)
	private String enddate;

	@Column(nullable = false)
	private String status;

	@Lob 
	@Column(length = 500)
	private String manager_feedback;
	
	@Column
	private int manager_ratings;

	@Lob // Use Lob annotation for large objects
	@Column(length = 500)
	private String hr_feedback;
	@Column
	private int hr_ratings;
	
	@Column
	private long hr_id;
	
	@Column
	private long manager_id;

	

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "employee_id")
	private Employee employee;
}
