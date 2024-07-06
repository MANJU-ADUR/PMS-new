package com.pms.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pms.project.entity.SentGoal;

public interface SentGoalRepository extends JpaRepository<SentGoal, Long> {

	@Query("select s from SentGoal s where s.manager.id=?1")
	List<SentGoal> findByManagerId(long manager_id);
}
