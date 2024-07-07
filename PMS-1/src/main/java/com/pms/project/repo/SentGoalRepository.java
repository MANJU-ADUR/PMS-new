package com.pms.project.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pms.project.entity.SentGoal;

public interface SentGoalRepository extends JpaRepository<SentGoal, Long> {

	@Query("select s from SentGoal s where s.manager.id=?1")
	List<SentGoal> findByManagerId(long manager_id);

	@Query("select s from SentGoal s where s.goal_id=?1")
	Optional<SentGoal> findByGoal_id(long goal_id);
}
