package com.pms.project.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pms.project.entity.Hr;

public interface HrRepository extends JpaRepository<Hr, Long> {

	@Query("select h from Hr h where h.email=?1 and h.password=?2")
	Optional<Hr> findByEmaiAndPassworsd(String email, String password);

}
