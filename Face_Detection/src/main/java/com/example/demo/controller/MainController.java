package com.example.demo.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Attendance;
import com.example.demo.model.Course;
import com.example.demo.model.CourseAssign;
import com.example.demo.model.Department;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.example.demo.services.CommenService;
import com.example.demo.services.SaveService;
import com.example.demo.services.ViewService;

@Controller
public class MainController {

	@Autowired
	private ViewService viewService;

	@Autowired
	private SaveService saveService;

	@Autowired
	private CommenService commenService;


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

	@RequestMapping(value = "/courseSave", method = RequestMethod.POST)
	public ModelAndView saveCourse(Course course) {
		saveService.saveCourse(course);
		return viewService.success();
	}

	@RequestMapping(value = "/departSave", method = RequestMethod.POST)
	public ModelAndView saveDepartment(Department department) {
		saveService.saveDepartment(department);
		return viewService.success();
	}

	@RequestMapping(value = "/courseAssignSave", method = RequestMethod.POST)
	public ModelAndView saveCourseAssign(@Valid CourseAssign courseAssign, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView();
		CourseAssign courseAssignExists = commenService.findByStudentIdAndCourseCode(courseAssign.getStudentId(),
				courseAssign.getCourseCode());
		if (courseAssignExists != null) {
			bindingResult.rejectValue("studentId", "error.courseAssign", "This course already exists for this student!");
		}
		if (bindingResult.hasErrors()) {
			model.setViewName("register/courseAssign");
		} else {
			saveService.saveCourseAssign(courseAssign);			
			model.addObject("msg", "User has been registered successfully!");
			model.addObject("courseAssign", new CourseAssign());
			model.setViewName("register/courseAssign");
		}
      return model;
		
	}
	
	@RequestMapping(value = "/searchAttentdance", method = RequestMethod.POST)
	public ModelAndView serachAtten(Model model,Attendance attendance,@RequestParam("attenDate") Date attenDate) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    String today = formatter.format(attenDate);
		return viewService.resutSearchAttendance(model,today, attendance.getCourseCode(),attendance.getAttendanceDate());
	}
	
	@RequestMapping(value = "/saveAttentdance", method = RequestMethod.POST)
	public ModelAndView saveAttendance(Attendance attendance,@RequestParam("attenDate") Date attenDate) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    String today = formatter.format(attenDate);
	    attendance.setAttendanceDate(today);
		saveService.saveAttendance(attendance);
		return viewService.success();
	}
	
    @RequestMapping(path = "/delete/{attendanceId}")
    public ModelAndView deleteAttendanceById(Model model, @PathVariable("attendanceId") int attendanceId){       
        return viewService.deleteAttendance(attendanceId);
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

	@RequestMapping(value = { "/Login" }, method = RequestMethod.GET)
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
	public ModelAndView courseInsertView(Model model) {
		return viewService.courseInsert(model);
	}

	@RequestMapping(value = "/courseAssignView", method = RequestMethod.GET)
	public ModelAndView courseAssignView(Model model) {
		return viewService.courseAssignInsert(model);
	}

	@RequestMapping(value = "/studentProfile", method = RequestMethod.GET)
	public ModelAndView studentHome() {
		return viewService.studentPro();
	}

	@RequestMapping(value = { "/access_denied" }, method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		ModelAndView model = new ModelAndView();
		model.setViewName("profile/access_denied");
		return model;
	}

	@RequestMapping(value = "/takePhotoExample", method = RequestMethod.GET)
	public ModelAndView takePhotoExample() {
		return viewService.teacherReg();
	}
	
	@RequestMapping(value = "/searchAttendance", method = RequestMethod.GET)
	public ModelAndView searchAttendance(Model model) {
		return viewService.searchAttendance(model);
	}
	
	@RequestMapping(value = "/addAttendance", method = RequestMethod.GET)
	public ModelAndView addAttendance(Model model) {
		return viewService.addAttendance(model);
	}

}
