package com.pms.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pms.project.dao.EmployeeDao;
import com.pms.project.dao.GoalDao;
import com.pms.project.dao.ManagerDao;
import com.pms.project.dao.SentGoalsDao;
import com.pms.project.dto.ResponseStructure;
import com.pms.project.entity.Employee;
import com.pms.project.entity.Goal;
import com.pms.project.entity.Manager;
import com.pms.project.entity.SentGoal;

@Service
public class SentGoalService {
	@Autowired
	private SentGoalsDao sentGoalsDao;
	@Autowired
	private ManagerDao managerDao;
	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private GoalService goalService;

	@Autowired
	private GoalDao goalDao;

	public ResponseEntity<ResponseStructure<SentGoal>> save(SentGoal sentGoals, Long emp_id, Long mgr_id) {
		ResponseStructure<SentGoal> structure = new ResponseStructure<>();
		Optional<Employee> recEmp = employeeDao.findById(emp_id);
		Optional<Manager> recMgr = managerDao.byid(mgr_id);
		if (recEmp.isPresent() && recMgr.isPresent()) {
			Employee dbEmp = recEmp.get();
			dbEmp.getSentGoals().add(sentGoals);
			Manager dbMgr = recMgr.get();
			dbMgr.getSentGoals().add(sentGoals);
			sentGoals.setEmployee(dbEmp);
			sentGoals.setManager(dbMgr);
			{
//				long id = sentGoals.getGoal_id();
//				Optional<Goal> goal = goalDao.findbyid(id);
//				Goal dbgoal = goal.get();
//				goalService.update(dbgoal);

			}
			structure.setData(sentGoalsDao.save(sentGoals));
			structure.setMessage("Goal Shared");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<SentGoal>>(structure, HttpStatus.OK);
		}
		return null;
	}

	public ResponseEntity<ResponseStructure<SentGoal>> update(SentGoal sentGoal) {
		ResponseStructure<SentGoal> structure = new ResponseStructure<>();
		Optional<SentGoal> recGoal = sentGoalsDao.byid(sentGoal.getId());
		if (recGoal.isPresent()) {
			SentGoal dbGoal = recGoal.get();
			dbGoal.setGoal_id(sentGoal.getGoal_id());
			dbGoal.setDescription(sentGoal.getDescription());
			dbGoal.setEnddate(sentGoal.getEnddate());
			dbGoal.setStartdate(sentGoal.getStartdate());
			dbGoal.setTitle(sentGoal.getTitle());
			dbGoal.setStatus(sentGoal.getStatus());
			dbGoal.setManager_feedback(sentGoal.getManager_feedback());
			dbGoal.setManager_ratings(sentGoal.getManager_ratings());
			dbGoal.setHr_feedback(sentGoal.getHr_feedback());
			dbGoal.setHr_ratings(sentGoal.getHr_ratings());
			
			sentGoalsDao.save(sentGoal);
			structure.setData(dbGoal);
			structure.setMessage("Updated");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<SentGoal>>(structure, HttpStatus.OK);
		}
		return null;
	}

	public ResponseEntity<ResponseStructure<List<SentGoal>>> bymanagerid(long id) {
		ResponseStructure<List<SentGoal>> structure = new ResponseStructure<>();
		Optional<Manager> recManager = managerDao.byid(id);
		if (recManager.isPresent()) {
			List<SentGoal> sentGoals = sentGoalsDao.bymanagerid(id);
			if (sentGoals.size() > 0) {
				structure.setData(sentGoals);
				structure.setMessage("Goals Fetched");
				structure.setStatuscode(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<List<SentGoal>>>(structure, HttpStatus.OK);
			}
			return null;
		}
		return null;
	}

	public ResponseEntity<ResponseStructure<SentGoal>> findsentgoalbygoal_id(Long id) {
		ResponseStructure<SentGoal> structure = new ResponseStructure<>();
		Optional<SentGoal> recGoal = sentGoalsDao.findsent_goal_by_goal_id(id);

		if (recGoal.isPresent()) {
			structure.setData(recGoal.get());
			structure.setMessage("Goal Found");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<SentGoal>>(structure, HttpStatus.OK);
		}
		return null;
	}

}
