package com.example2MVC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example2MVC.model.StudentData66;


public interface StudentRepo extends JpaRepository<StudentData66, Integer> {

	@Query("SELECT s FROM StudentData66 s JOIN s.timings t WHERE t IN :timings GROUP BY s HAVING COUNT(t) >= 1")
	List<StudentData66> findByTimings(List<String> timings);

	List<StudentData66> findByTimingsIn(List<String> timings);

}
