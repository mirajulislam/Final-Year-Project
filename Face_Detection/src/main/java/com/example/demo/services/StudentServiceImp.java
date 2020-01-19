package com.example.demo.services;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Role;
import com.example.demo.model.Student;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.StudentRepository;
@Service
public class StudentServiceImp implements StudentService{
	
	 @Autowired
	 private RoleRepository roleRepository;
	 @Autowired
	 private StudentRepository studentRepository;
	 
	@Autowired
		BCryptPasswordEncoder encoder;
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());

	@Override
	public void saveStudent(Student student) {
		student.setPassword(encoder.encode(student.getPassword()));
		student.setTx_created_date(timestamp);
		Role studentRole=roleRepository.findByRoleName("student_user");
		student.setRoles(new HashSet<Role>(Arrays.asList(studentRole)));
		studentRepository.save(student);
		
	}

	@Override
	public Student findByUserName(String userName) {
		// TODO Auto-generated method stub
		return studentRepository.findByUserName(userName);
	}

}
