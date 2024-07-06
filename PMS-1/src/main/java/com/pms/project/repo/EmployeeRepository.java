package com.pms.project.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pms.project.entity.Employee;
import com.pms.project.entity.Registration;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("select e from Employee e where e.email=?1 and e.password=?2")
	Optional<Employee> findByEmaiAndPassworsd(String email, String password);
}
