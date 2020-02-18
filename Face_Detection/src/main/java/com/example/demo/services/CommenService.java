package com.example.demo.services;


import com.example.demo.model.CourseAssign;

public interface CommenService {
	
	CourseAssign findByStudentIdAndCourseCode(int studentId, String courseCode);

}
