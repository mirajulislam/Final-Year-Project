package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.example.demo.services.StudentServiceImp;
import com.example.demo.services.TeacherServiceImp;
import com.example.demo.services.ViewService;

@Controller
public class MainController {
	
	@Autowired
	private ViewService viewService;
	
	@Autowired
	private TeacherServiceImp teacherServiceImp;
	
	@Autowired
	private StudentServiceImp studentServiceImp;
	
	@RequestMapping(value = "/Teacher-register", method = RequestMethod.GET)
	public ModelAndView teacherRegister() {
		return viewService.teacherReg();
	
	}	

	@RequestMapping(value = "/Student-register", method = RequestMethod.GET)
	public ModelAndView studentRegister() {
		return viewService.studentReg();	
	}	
	
	@RequestMapping(value = "/teacherRegisterSave", method = RequestMethod.POST)
	public void saveTeacher(Teacher teacher) {
		 teacherServiceImp.saveTeache(teacher);
		
	}
	
	@RequestMapping(value = "/studentRegisterSave", method = RequestMethod.POST)
	public void saveStudent(Student student) {	 
		studentServiceImp.saveStudent(student);
	}
	
	
	
}
