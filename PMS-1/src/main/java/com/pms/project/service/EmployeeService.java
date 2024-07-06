package com.pms.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pms.project.dao.EmployeeDao;
import com.pms.project.dto.ResponseStructure;
import com.pms.project.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public ResponseEntity<ResponseStructure<Employee>> save(Employee employee) {
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		structure.setData(employeeDao.save(employee));
		structure.setMessage("Employee Successfull");
		structure.setStatuscode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Employee>> findByEmailAndPassword(String email, String password) {
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		Optional<Employee> recEmployee = employeeDao.findByEmailAndPassword(email, password);
		if (recEmployee.isPresent()) {
			structure.setData(recEmployee.get());
			structure.setMessage("Login Succesfull");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		}
		return null;
	}

	public ResponseEntity<ResponseStructure<Employee>> findbyid(long id) {
		ResponseStructure<Employee> structure = new ResponseStructure<>();

		Optional<Employee> recEmp = employeeDao.findById(id);
		if (recEmp.isPresent()) {
			structure.setData(recEmp.get());
			structure.setMessage("Emp Received");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		}
		return null;
	}

}
