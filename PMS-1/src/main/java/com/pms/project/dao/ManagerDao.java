package com.pms.project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pms.project.entity.Manager;
import com.pms.project.repo.ManagerRepository;

@Repository
public class ManagerDao {

	@Autowired
	private ManagerRepository managerRepository;

	public Manager save(Manager manager) {
		return managerRepository.save(manager);
	}

	public Optional<Manager> findByEmailAndPassword(String email, String password) {
		return managerRepository.findByEmaiAndPassworsd(email, password);
	}

	public List<Manager> findall() {
		return managerRepository.findAll();
	}
	
	public Optional<Manager> byid(Long id){
		return managerRepository.findById(id);
	}
}
