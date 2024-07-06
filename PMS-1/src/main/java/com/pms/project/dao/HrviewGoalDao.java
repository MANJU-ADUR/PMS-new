package com.pms.project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pms.project.entity.HrViewGoal;
import com.pms.project.repo.HrviewGoalRepo;


@Repository
public class HrviewGoalDao {
	
	@Autowired
	private HrviewGoalRepo hrviewGoalRepo;

	public HrViewGoal save(HrViewGoal hrViewGoal) {
		return hrviewGoalRepo.save(hrViewGoal);
	}

	public List<HrViewGoal> by_hr_id(long id) {
		return hrviewGoalRepo.findbyHrId(id);

	}

}
