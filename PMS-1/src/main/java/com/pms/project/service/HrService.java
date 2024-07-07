package com.pms.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pms.project.dao.HrDao;
import com.pms.project.dto.ResponseStructure;
import com.pms.project.entity.Hr;

@Service
public class HrService {

	@Autowired
	private HrDao hrDao;

	public ResponseEntity<ResponseStructure<Hr>> save(Hr hr) {
		ResponseStructure<Hr> structure = new ResponseStructure<>();
		structure.setData(hrDao.save(hr));
		structure.setMessage("Hr saved");
		structure.setStatuscode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Hr>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Hr>> findByEmailAndPassword(String email, String password) {
		ResponseStructure<Hr> structure = new ResponseStructure<>();
		Optional<Hr> recEmployee = hrDao.findByEmailAndPassword(email, password);
		if (recEmployee.isPresent()) {
			structure.setData(recEmployee.get());
			structure.setMessage("Login Succesfull");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Hr>>(structure, HttpStatus.OK);
		}
		return null;
	}

	public ResponseEntity<ResponseStructure<List<Hr>>> findall() {
		ResponseStructure<List<Hr>> structure = new ResponseStructure<>();
		List<Hr> hrs = hrDao.findall();
		if (hrs.size() > 0) {
			structure.setData(hrs);
			structure.setMessage("Hr's");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Hr>>>(structure, HttpStatus.OK);
		}
		return null;
	}
}
