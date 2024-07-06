package com.pms.project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pms.project.entity.Employee;
import com.pms.project.entity.Goal;
import com.pms.project.repo.GoalsRepository;

@Repository
public class GoalDao {

	@Autowired
	private GoalsRepository goalsRepository;

	public Goal save(Goal goal) {
		return goalsRepository.save(goal);
	}

	public String deletebyid(long id) {
		goalsRepository.deleteById(id);
		return "Deleted";
	}

	public Optional<Goal> findbyid(Long id) {
		return goalsRepository.findById(id);
	}

	public List<Goal> findby_emp_id(long emp_id) {
		return goalsRepository.findByEmployeeId(emp_id);
	}

	public Optional<Employee> findempbygoalid(long id) {
		return goalsRepository.findEmployeeByGoal(id);
	}
}
