package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Attendance;
import com.example.demo.model.Course;
import com.example.demo.model.CourseAssign;
import com.example.demo.model.Department;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.example.demo.repository.AttendanceRepository;
import com.example.demo.repository.CourseAssignRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.DepartmentRepository;

@Service
public class SaveService {
	
	@Autowired
	private CourseRepository courseRepository; 
	@Autowired 
	private DepartmentRepository departmentRepository;
	@Autowired 
	private CourseAssignRepository courseAssignRepository;
	@Autowired
	private TeacherServiceImp teacherServiceImp;
	@Autowired
	private StudentServiceImp studentServiceImp;
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	
	//Course Save
	public void saveCourse(Course course) {
		courseRepository.save(course);
	}
	
	//department save
	public void saveDepartment(Department department) {
		departmentRepository.save(department);
	}

	// CourseAssign save
	public void saveCourseAssign(CourseAssign courseAssign) {
		courseAssignRepository.save(courseAssign);
	}
	
	//studentSave
	public void saveStudent(Student student) {
		studentServiceImp.saveStudent(student);
	}
	
	//teacherSave
	
	public void saveTeacher(Teacher teacher) {
		teacherServiceImp.saveTeache(teacher);
	}
	
	public void saveAttendance(Attendance attendance) {
		attendanceRepository.save(attendance);
	}
}
