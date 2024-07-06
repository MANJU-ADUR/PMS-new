package com.pms.project.controller;

import java.util.List;

import javax.imageio.spi.RegisterableService;

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
import com.pms.project.entity.Manager;
import com.pms.project.service.ManagerService;

@RestController
@RequestMapping("/manager")
@CrossOrigin("*")
public class ManagerController {

	@Autowired
	private ManagerService managerService;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Manager>> save(@RequestBody Manager manager) {
		return managerService.save(manager);
	}

	@PostMapping("find-by-email-password")
	public ResponseEntity<ResponseStructure<Manager>> findByEmailAndPassword(@RequestParam String email,
			@RequestParam String password) {
		return managerService.findByEmailAndPassword(email, password);
	}

	@GetMapping("managers")
	public ResponseEntity<ResponseStructure<List<Manager>>> allmanagers() {
		return managerService.findall();
	}

}
