package com.pms.project.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pms.project.entity.Registration;
import com.pms.project.repo.RegistrationRepository;

@Repository
public class RegistrationDao {

	@Autowired
	private RegistrationRepository registrationRepository;

	public Registration save(Registration registration) {
		return registrationRepository.save(registration);
	}
	
	public Optional<Registration> findByEmailAndPassword(String email,String password){
		return registrationRepository.findByEmaiAndPassworsd(email, password);
	}

}
