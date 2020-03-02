package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.CourseAssign;

public interface CourseAssignRepository extends JpaRepository<CourseAssign, Integer>{
	
	CourseAssign findByStudentIdAndCourseCode(int studentId, String courseCode);
	@Query("SELECT DISTINCT courseCode FROM CourseAssign")
	List<String> findDistinctByCourseCode();
	@Query("SELECT DISTINCT departmentShortName FROM CourseAssign")
	List<String> findDistinctByDepartmentShortName();

}
