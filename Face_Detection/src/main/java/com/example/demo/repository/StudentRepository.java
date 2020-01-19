package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;
import com.example.demo.model.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<Student, Integer>{
	 Student findByUserName(String userName);
}
