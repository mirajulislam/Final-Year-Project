package com.example.demo.services;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Role;
import com.example.demo.model.Teacher;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.TeacherRepository;
@Service
public class TeacherServiceImp implements TeacherService{
	
	 @Autowired
	 private RoleRepository roleRepository;
	 @Autowired TeacherRepository teacherRepository;
	 
	@Autowired
	private	BCryptPasswordEncoder encoder;
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());

	@Override
	public void saveTeache(Teacher teacher) {
		teacher.setPassword(encoder.encode(teacher.getPassword()));
		teacher.setTx_created_date(timestamp);
		Role teacherRole=roleRepository.findByRoleName("teacher_user");
		teacher.setRoles(new HashSet<Role>(Arrays.asList(teacherRole)));
		teacherRepository.save(teacher);		
	}

	@Override
	public Teacher findByUserName(String userName) {
		return teacherRepository.findByUserName(userName);
	}

}
