package com.pms.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pms.project.dao.EmployeeDao;
import com.pms.project.dao.GoalDao;
import com.pms.project.dao.HrDao;
import com.pms.project.dao.HrviewGoalDao;
import com.pms.project.dao.ManagerDao;
import com.pms.project.dao.SentGoalsDao;
import com.pms.project.dto.ResponseStructure;
import com.pms.project.entity.Employee;
import com.pms.project.entity.Goal;
import com.pms.project.entity.Hr;
import com.pms.project.entity.HrViewGoal;
import com.pms.project.entity.Manager;
import com.pms.project.entity.SentGoal;

@Service
public class HrviewGoalService {

	@Autowired
	private HrviewGoalDao hrviewGoalDao;

	@Autowired
	private GoalDao goalDao;

	@Autowired
	private SentGoalsDao sentGoalsDao;
	@Autowired
	private ManagerDao managerDao;
	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private HrDao hrDao;

	@Autowired
	private GoalService goalService;

	@Autowired
	private SentGoalService sentGoalService;

	public ResponseEntity<ResponseStructure<HrViewGoal>> save(HrViewGoal hrViewGoals, Long emp_id, Long mgr_id,
			long hr_id) {
		ResponseStructure<HrViewGoal> structure = new ResponseStructure<>();
		Optional<Employee> recEmp = employeeDao.findById(emp_id);
		Optional<Manager> recMgr = managerDao.byid(mgr_id);
		Optional<Hr> recHR = hrDao.byid(hr_id);
		if (recEmp.isPresent() && recMgr.isPresent() && recHR.isPresent()) {
			Employee dbEmp = recEmp.get();
			dbEmp.getHrViewGoals().add(hrViewGoals);
			Manager dbmanManager = recMgr.get();
			dbmanManager.getHrViewGoals().add(hrViewGoals);
			Hr dbhr = recHR.get();
			dbhr.getHrViewGoals().add(hrViewGoals);
			hrViewGoals.setEmployee(dbEmp);
			hrViewGoals.setHr(dbhr);
			hrViewGoals.setManager(dbmanManager);
			{
				long id=hrViewGoals.getGoal_id();
				Optional<Goal> goal = goalDao.findbyid(id);
				Goal dbgoal = goal.get();
				goalService.update1(dbgoal);

//				long id1 = sentGoals.getGoal_id();
//				Optional<Goal> goal = goalDao.findbyid(id);
//				Goal dbgoal = goal.get();
//				goalService.update(dbgoal);
//				long id = hrViewGoals.getMangerGoalid();
//				Optional<SentGoal> goal=sentGoalsDao.byid(id);
//				SentGoal dbgoal = goal.get();
//				sentGoalService.update(dbgoal);
//				long id1 = hrViewGoals.getGoal_id();
//				Optional<Goal> goal1=goalDao.findbyid(id1);
//				Goal dbgoal1 = goal1.get();
//				sentGoalService.update(dbgoal);

			}
			structure.setData(hrviewGoalDao.save(hrViewGoals));
			structure.setMessage("Goal Shared");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<HrViewGoal>>(structure, HttpStatus.OK);
		}
		return null;
	}

//	ResponseStructure<List<SentGoal>> structure = new ResponseStructure<>();
//	Optional<Manager> recManager = managerDao.byid(id);
//	if (recManager.isPresent()) {
//		List<SentGoal> sentGoals = sentGoalsDao.bymanagerid(id);
//		if (sentGoals.size() > 0) {
//			structure.setData(sentGoals);
//			structure.setMessage("Goals Fetched");
//			structure.setStatuscode(HttpStatus.OK.value());
//			return new ResponseEntity<ResponseStructure<List<SentGoal>>>(structure, HttpStatus.OK);
//		}
//		return null;
//	}
//	return null;

	public ResponseEntity<ResponseStructure<List<HrViewGoal>>> byyhrid(long id) {
		ResponseStructure<List<HrViewGoal>> structure = new ResponseStructure<>();
		Optional<Hr> recHr = hrDao.byid(id);
		if (recHr.isPresent()) {
			List<HrViewGoal> hrViewGoals = hrviewGoalDao.by_hr_id(id);
			if (hrViewGoals.size() > 0) {
				structure.setData(hrViewGoals);
				structure.setMessage("Goals Fetched");
				structure.setStatuscode(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<List<HrViewGoal>>>(structure, HttpStatus.OK);
			}
			return null;
		}
		return null;
	}

	public ResponseEntity<ResponseStructure<HrViewGoal>> findgoalbyid(long id) {
		ResponseStructure<HrViewGoal> structure = new ResponseStructure<>();
		Optional<HrViewGoal> recGoal = hrviewGoalDao.findgoalbyid(id);
		if (recGoal.isPresent()) {
			structure.setData(recGoal.get());
			structure.setMessage("Goal Fetched");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<HrViewGoal>>(structure, HttpStatus.OK);
		}
		return null;
	}

}
