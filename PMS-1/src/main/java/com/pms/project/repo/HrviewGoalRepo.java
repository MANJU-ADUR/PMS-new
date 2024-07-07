package com.pms.project.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pms.project.entity.HrViewGoal;

public interface HrviewGoalRepo extends JpaRepository<HrViewGoal, Long> {
	
	@Query("select h from HrViewGoal h where h.hr.id=?1")
	List<HrViewGoal> findbyHrId(Long hr_id);
	
}
