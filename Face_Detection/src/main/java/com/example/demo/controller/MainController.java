package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Course;
import com.example.demo.model.CourseAssign;
import com.example.demo.model.Department;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.example.demo.services.SaveService;
import com.example.demo.services.StudentServiceImp;
import com.example.demo.services.TeacherService;
import com.example.demo.services.TeacherServiceImp;
import com.example.demo.services.ViewService;

@Controller
public class MainController {

	@Autowired
	private ViewService viewService;

	@Autowired
	private SaveService saveService; 
	
	
	@RequestMapping(value = "/teacherRegisterSave", method = RequestMethod.POST)
	public ModelAndView saveTeacher(Teacher teacher) {
		saveService.saveTeacher(teacher);
		return viewService.success();

	}

	@RequestMapping(value = "/studentRegisterSave", method = RequestMethod.POST)
	public ModelAndView saveStudent(Student student) {
		saveService.saveStudent(student);
		return viewService.success();
	}
	
	@RequestMapping(value = "/studentRegisterSave", method = RequestMethod.POST)
	public ModelAndView saveCourse(Course course) {
		saveService.saveCourse(course);
		return viewService.success();
	}
	
	@RequestMapping(value = "/studentRegisterSave", method = RequestMethod.POST)
	public ModelAndView saveDepartment(Department department) {
		saveService.saveDepartment(department);
		return viewService.success();
	}
	
	@RequestMapping(value = "/studentRegisterSave", method = RequestMethod.POST)
	public ModelAndView saveCourseAssign(CourseAssign courseAssign) {
		saveService.saveCourseAssign(courseAssign);
		return viewService.success();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homePage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;

	}

	@RequestMapping(value = "/Teacher-register", method = RequestMethod.GET)
	public ModelAndView teacherRegister() {
		return viewService.teacherReg();

	}

	@RequestMapping(value = "/Student-register", method = RequestMethod.GET)
	public ModelAndView studentRegister() {
		return viewService.studentReg();
	}
	
	@RequestMapping(value = {"/Login"}, method = RequestMethod.GET)
	public ModelAndView login() {
		return viewService.logIn();
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
	
	@RequestMapping(value = "/deparmentInsertView", method = RequestMethod.GET)
	public ModelAndView deparmentInsertView() {	 
		return viewService.departmentInsert();
	}
	
	@RequestMapping(value = "/courseInsertView", method = RequestMethod.GET)
	public ModelAndView courseInsertView() {	 
		return viewService.courseInsert();
	}
	
	@RequestMapping(value = "/courseAssignView", method = RequestMethod.GET)
	public ModelAndView courseAssignView(Model model) {	 
		return viewService.courseAssignInsert(model);
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
	 
	 @RequestMapping(value = "/takePhotoExample", method = RequestMethod.GET)
		public ModelAndView takePhotoExample() {
			return viewService.teacherReg();
		}

}
