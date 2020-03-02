package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CourseAssign;

public interface CourseAssignRepository extends JpaRepository<CourseAssign, Integer>{
	
	CourseAssign findByStudentIdAndCourseCode(int studentId, String courseCode);

}
