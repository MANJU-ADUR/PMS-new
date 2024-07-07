package com.pms.project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pms.project.entity.SentGoal;
import com.pms.project.repo.SentGoalRepository;

@Repository
public class SentGoalsDao {

	@Autowired
	private SentGoalRepository sentGoalRepository;

	public SentGoal save(SentGoal sentGoal) {
		return sentGoalRepository.save(sentGoal);
	}

	public List<SentGoal> bymanagerid(long id) {
		return sentGoalRepository.findByManagerId(id);
	}

	public Optional<SentGoal> byid(Long id) {
		return sentGoalRepository.findById(id);
	}

	public Optional<SentGoal> findsent_goal_by_goal_id(Long id) {
		return sentGoalRepository.findByGoal_id(id);
	}

}
