package com.pms.project.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pms.project.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

	@Query("select r from Registration r where r.email=?1 and r.password=?2")
	Optional<Registration> findByEmaiAndPassworsd(String email, String password);
	

}
