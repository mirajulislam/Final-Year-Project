package com.example.demo.services;

import com.example.demo.model.Student;
import com.example.demo.model.Teacher;

public interface StudentService {
	public void saveStudent(Student student);
	public Student findByUserName(String userName);	
}
