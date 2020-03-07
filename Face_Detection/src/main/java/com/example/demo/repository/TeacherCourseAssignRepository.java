package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TeacherCourseAssign;

public interface TeacherCourseAssignRepository extends JpaRepository<TeacherCourseAssign, Integer>{
	TeacherCourseAssign findByTeacherIdAndCourseCode(int teacherId, String courseCode);

}
