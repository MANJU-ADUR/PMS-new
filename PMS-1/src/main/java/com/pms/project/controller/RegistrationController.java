package com.pms.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.project.dto.ResponseStructure;
import com.pms.project.entity.Registration;
import com.pms.project.service.RegistrationService;

@RestController
@RequestMapping("/register")
@CrossOrigin("*")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Registration>> save(@RequestBody Registration registration) {
		return registrationService.save(registration);
	}

	@PostMapping("find-by-email-password")
	public ResponseEntity<ResponseStructure<Registration>> findByEmailAndPassword(@RequestParam String email,
			@RequestParam String password) {
		return registrationService.findByEmailAndPassword(email, password);
	}

}
