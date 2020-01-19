package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
@Service
public class ViewService {
	
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService studentService;
	
	public ModelAndView teacherReg() {   
		Teacher teacher=new Teacher();
        ModelAndView mav = new ModelAndView();
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

}
