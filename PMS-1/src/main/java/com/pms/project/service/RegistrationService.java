package com.pms.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.pms.project.dao.RegistrationDao;
import com.pms.project.dto.ResponseStructure;
import com.pms.project.entity.Registration;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationDao registrationDao;

	public ResponseEntity<ResponseStructure<Registration>> save(Registration registration) {
		ResponseStructure<Registration> structure = new ResponseStructure<>();
		structure.setData(registrationDao.save(registration));
		structure.setMessage("Registration Successfull");
		structure.setStatuscode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Registration>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Registration>> findByEmailAndPassword(String email, String password) {
		ResponseStructure<Registration> structure = new ResponseStructure<>();
		Optional<Registration> recRegistration = registrationDao.findByEmailAndPassword(email, password);
		if (recRegistration.isPresent()) {
			structure.setData(recRegistration.get());
			structure.setMessage("Login Succesfull");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Registration>>(structure, HttpStatus.OK);
		}
		return null;
	}

}
