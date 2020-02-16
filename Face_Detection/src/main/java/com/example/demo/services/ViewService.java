package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Course;
import com.example.demo.model.Department;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
@Service
public class ViewService {
	
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private FindAllService findAllService;
	
	public ModelAndView teacherReg() {   
		Teacher teacher=new Teacher();
        ModelAndView mav = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        teacherService.findByUserName(auth.getName());
        mav.addObject("userName", teacher.getFirstName()+" "+ teacher.getLastName());
        mav.addObject("teacher", teacher);
        mav.setViewName("userRegister/teacherReg");
        return mav;
    }
	
	public ModelAndView studentReg() {     
        ModelAndView mav = new ModelAndView();
        mav.setViewName("userRegister/studentReg");
        return mav;
    }
	
	public ModelAndView success() {     
        ModelAndView mav = new ModelAndView();
        mav.setViewName("userRegister/Successfully");
        return mav;
    }
	
	public ModelAndView logIn() {     
        ModelAndView mav = new ModelAndView();
        mav.setViewName("userRegister/login");
        return mav;
    }
	
	public ModelAndView teacherPro() {     
		ModelAndView mav = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Teacher teacher=teacherService.findByUserName(auth.getName());
        mav.addObject("userName", teacher.getFirstName()+" "+ teacher.getLastName());
        mav.setViewName("profile/teacherProfile");
        return mav;
    }
	
	public ModelAndView studentPro() {     
		ModelAndView mav = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Student student=studentService.findByUserName(auth.getName());
        mav.addObject("userName", student.getFirstName()+" "+ student.getLastName());
        mav.setViewName("profile/studentProfile");
        return mav;
    }

	public ModelAndView courseInsert() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("register/course");
        return mav;
	}
	
	public ModelAndView departmentInsert() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("register/department");
        return mav;
	}
	
	public ModelAndView courseAssignInsert(Model model) {
		ModelAndView mav = new ModelAndView();
		List<Student>studentList=findAllService.listStudent();
		List<Teacher>teacherList=findAllService.listTeacher();
		List<Course>courseList=findAllService.listCourse();
		List<Department>departmentList=findAllService.listDepartment();
		model.addAttribute("studentList",studentList);
		model.addAttribute("teacherList",teacherList);
		model.addAttribute("courseList",courseList);
		model.addAttribute("departmentList",departmentList);
		mav.setViewName("register/courseAssign");
        return mav;
	}	
}
