package com.pms.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.project.dto.ResponseStructure;
import com.pms.project.entity.Employee;
import com.pms.project.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Employee>> save(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}

	@PostMapping("/find-by-email-password")
	public ResponseEntity<ResponseStructure<Employee>> findByEmailAndPassword(@RequestParam String email,
			@RequestParam String password) {
		return employeeService.findByEmailAndPassword(email, password);
	}

	@GetMapping("/find-by-id/{id}")
	public ResponseEntity<ResponseStructure<Employee>> byid(@PathVariable long id) {
		return employeeService.findbyid(id);
	}

}
