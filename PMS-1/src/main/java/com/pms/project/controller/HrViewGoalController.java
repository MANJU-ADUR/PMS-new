package com.pms.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.project.dto.ResponseStructure;
import com.pms.project.entity.HrViewGoal;
import com.pms.project.service.HrviewGoalService;

@RestController
@RequestMapping("/hrgoals")
public class HrViewGoalController {
	
	@Autowired
	private HrviewGoalService hrviewGoalService;

//	@PostMapping("/save/{emp_id}/{mgr_id}")
//	public ResponseEntity<ResponseStructure<hr>> save(@RequestBody SentGoal sentGoal, @PathVariable long emp_id,
//			@PathVariable long mgr_id) {
//		return sentGoalService.save(sentGoal, emp_id, mgr_id);
//	}
	
	@PostMapping("/save/{emp_id}/{mgr_id}/{hr_id}")
	public ResponseEntity<ResponseStructure<HrViewGoal>> save( HrViewGoal hrViewGoal,long emp_id,long mgr_id,long hr_id) {
		return hrviewGoalService.save(hrViewGoal, emp_id, mgr_id, hr_id);
	}

	@GetMapping("employee-and-manager-approved-goals/{id}")
	public ResponseEntity<ResponseStructure<List<HrViewGoal>>> findsentgoals_by_hr_id(@PathVariable long id) {
		return hrviewGoalService.byyhrid(id);
	}

}
