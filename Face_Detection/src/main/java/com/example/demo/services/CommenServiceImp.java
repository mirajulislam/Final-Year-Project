package com.example.demo.services;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Attendance;
import com.example.demo.model.CourseAssign;
import com.example.demo.repository.AttendanceRepository;
import com.example.demo.repository.CourseAssignRepository;
@Service
public class CommenServiceImp implements CommenService{
     @Autowired
     private CourseAssignRepository courseAssignRepository;
     @Autowired
     private AttendanceRepository attendanceRepository;
     
     SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
     
	@Override
	public CourseAssign findByStudentIdAndCourseCode(int studentId, String courseCode) {
		return courseAssignRepository.findByStudentIdAndCourseCode(studentId, courseCode);
	}
	
	@Override
	public List<Attendance> findByAttendanceDateAndCourseCodeAndDepartmentShortName(String attendanceDate, String courseCode, String departmentShortName) {
		return attendanceRepository.findByAttendanceDateAndCourseCode(attendanceDate, courseCode);
	}

}
