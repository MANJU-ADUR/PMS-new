package com.pms.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.project.dto.ResponseStructure;
import com.pms.project.entity.Employee;
import com.pms.project.entity.Goal;
import com.pms.project.service.GoalService;

@RestController
@RequestMapping("/goals")
@CrossOrigin("*")
public class GoalController {

	@Autowired
	private GoalService goalService;

	@PostMapping("/save/{id}")
	public ResponseEntity<ResponseStructure<Goal>> save(@RequestBody Goal goal,
			@PathVariable(name = "id") long employee_id) {
		return goalService.save(goal, employee_id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deletebyid(@PathVariable long id) {
		return goalService.deletebyid(id);
	}

	@GetMapping("goals-by-employee/{emp_id}")
	public ResponseEntity<ResponseStructure<List<Goal>>> findby_emp_id(@PathVariable Long emp_id) {
		return goalService.findby_emp_id(emp_id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Goal>> findbyid(@PathVariable long id) {
		return goalService.bygoalid(id);
	}

	@GetMapping("find-emp/{id}")
	public ResponseEntity<ResponseStructure<Employee>> findemp_by_goal_id(@PathVariable long id) {
		return goalService.findempidbygoal(id);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Goal>> update(@RequestBody Goal goal) {
		return goalService.update(goal);
	}
}
