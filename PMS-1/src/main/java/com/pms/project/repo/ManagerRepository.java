package com.pms.project.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pms.project.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

	@Query("select m from Manager m where m.email=?1 and m.password=?2")
	Optional<Manager> findByEmaiAndPassworsd(String email, String password);
	
}
