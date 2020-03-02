package com.example.demo.services;
import java.util.List;

import com.example.demo.model.Attendance;
import com.example.demo.model.CourseAssign;

public interface CommenService {
	
	CourseAssign findByStudentIdAndCourseCode(int studentId, String courseCode);
	List<Attendance> findByAttendanceDateAndCourseCodeAndDepartmentShortName(String attendanceDate,String courseCode, String departmentShortName);

}
