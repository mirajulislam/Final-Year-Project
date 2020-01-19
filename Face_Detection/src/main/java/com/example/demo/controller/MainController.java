package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.example.demo.services.StudentServiceImp;
import com.example.demo.services.TeacherService;
import com.example.demo.services.TeacherServiceImp;
import com.example.demo.services.ViewService;
import org.springframework.security.core.Authentication;

@Controller
public class MainController {

	@Autowired
	private ViewService viewService;

	@Autowired
	private TeacherServiceImp teacherServiceImp;
	@Autowired
	private TeacherService teacherService;
	

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
	
	@RequestMapping(value = {"/","/Login"}, method = RequestMethod.GET)
	public ModelAndView login() {
		return viewService.logIn();
	}
	
	@RequestMapping(value = "/teacherRegisterSave", method = RequestMethod.POST)
	public ModelAndView saveTeacher(Teacher teacher) {
		teacherServiceImp.saveTeache(teacher);
		return viewService.success();

	}

	@RequestMapping(value = "/studentRegisterSave", method = RequestMethod.POST)
	public ModelAndView saveStudent(Student student) {
		studentServiceImp.saveStudent(student);
		return viewService.success();
	}

	// show user home page
	@RequestMapping(value = "/userhome", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		return modelAndView;
	}

	// show user home page
	@RequestMapping(value = "/teacherProfile", method = RequestMethod.GET)
	public ModelAndView teacherHome() {	 
		return viewService.teacherPro();
	}
	
	@RequestMapping(value = "/studentProfile", method = RequestMethod.GET)
	public ModelAndView studentHome() {	 
		return viewService.studentPro();
	}
	
	 @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
	 public ModelAndView accessDenied() {
	  ModelAndView model = new ModelAndView();
	  model.setViewName("profile/access_denied");
	  return model;
	 }

}
