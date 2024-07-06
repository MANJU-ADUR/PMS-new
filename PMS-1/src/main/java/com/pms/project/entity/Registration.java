package com.pms.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Registration {
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
	private String Designation;
	@Column(nullable = false, unique = true)
	private long mobilenumber;
	@Column(nullable = false, unique = true)
	private String email;

}
