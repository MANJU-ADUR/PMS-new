package com.pms.project.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pms.project.entity.Employee;
import com.pms.project.repo.EmployeeRepository;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Optional<Employee> findByEmailAndPassword(String email, String password) {
		return employeeRepository.findByEmaiAndPassworsd(email, password);
	}

	public Optional<Employee> findById(long id) {
		return employeeRepository.findById(id);
	}

}
