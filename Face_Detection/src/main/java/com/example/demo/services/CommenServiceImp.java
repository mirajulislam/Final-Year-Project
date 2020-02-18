package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CourseAssign;
import com.example.demo.repository.CourseAssignRepository;
@Service
public class CommenServiceImp implements CommenService{
     @Autowired
     private CourseAssignRepository courseAssignRepository;
	@Override
	public CourseAssign findByStudentIdAndCourseCode(int studentId, String courseCode) {
		return courseAssignRepository.findByStudentIdAndCourseCode(studentId, courseCode);
	}

}
