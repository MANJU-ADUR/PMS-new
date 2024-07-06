package com.pms.project.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pms.project.entity.Hr;
import com.pms.project.repo.HrRepository;

@Repository
public class HrDao {

	@Autowired
	private HrRepository hrRepository;

	public Hr save(Hr hr) {
		return hrRepository.save(hr);
	}

	public Optional<Hr> findByEmailAndPassword(String email, String password) {
		return hrRepository.findByEmaiAndPassworsd(email, password);
	}

	public Optional<Hr> byid(long id) {
		return hrRepository.findById(id);
	}

}
