package com.pms.project.controller;

import javax.imageio.spi.RegisterableService;

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
import com.pms.project.entity.Hr;
import com.pms.project.service.HrService;

@RestController
@RequestMapping("/hr")
@CrossOrigin("*")
public class HrController {

	@Autowired
	private HrService hrService;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Hr>> save(@RequestBody Hr hr) {
		return hrService.save(hr);
	}

	@PostMapping
	public ResponseEntity<ResponseStructure<Hr>> findByEmailAndPassword(@RequestParam String email,
			@RequestParam String password) {
		return hrService.findByEmailAndPassword(email, password);
	}

}
