package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
import com.example.demo.model.CourseAssign;
import com.example.demo.model.Department;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.example.demo.repository.CourseAssignRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TeacherRepository;
@Service
public class FindAllService {
	
	@Autowired
	private CourseRepository courseRepository; 
	@Autowired 
	private DepartmentRepository departmentRepository;
	@Autowired 
	private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private CourseAssignRepository courseAssignRepository;

    public List<Student>listStudent(){
		return studentRepository.findAll();   	
    }
    
    public List<Teacher>listTeacher(){
		return teacherRepository.findAll();   	
    }
    
    public List<Course>listCourse(){
		return courseRepository.findAll();   	
    }
    
    public List<Department>listDepartment(){
		return departmentRepository.findAll();   	
    }
    
    public List<CourseAssign>listCourseAssign(){
		return courseAssignRepository.findAll();   	
    }
}
