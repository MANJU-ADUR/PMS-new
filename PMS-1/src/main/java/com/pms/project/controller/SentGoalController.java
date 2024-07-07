package com.pms.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.project.dto.ResponseStructure;
import com.pms.project.entity.SentGoal;
import com.pms.project.service.SentGoalService;

@RestController
@RequestMapping("/setgoals")
@CrossOrigin("*")
public class SentGoalController {

	@Autowired
	private SentGoalService sentGoalService;

	@PostMapping("/save/{emp_id}/{mgr_id}")
	public ResponseEntity<ResponseStructure<SentGoal>> save(@RequestBody SentGoal sentGoal, @PathVariable long emp_id,
			@PathVariable long mgr_id) {
		return sentGoalService.save(sentGoal, emp_id, mgr_id);
	}

	@GetMapping("employee-goals/{id}")
	public ResponseEntity<ResponseStructure<List<SentGoal>>> findsentgoals_by_manager_id(@PathVariable long id) {
		return sentGoalService.bymanagerid(id);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<SentGoal>> update(@RequestBody SentGoal sentGoal) {
		return sentGoalService.update(sentGoal);
	}
	
	@GetMapping("find/sentgoal/{id}")
	public ResponseEntity<ResponseStructure<SentGoal>> findsentgoalby_goal_id(@PathVariable Long id) {
		return sentGoalService.findsentgoalbygoal_id(id);
	}
	
	

}
