package com.example.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
@Service
public class ViewService {
	
	public ModelAndView teacherReg() {     
        ModelAndView mav = new ModelAndView();
        mav.setViewName("userRegister/teacherReg");
        return mav;
    }
	
	public ModelAndView studentReg() {     
        ModelAndView mav = new ModelAndView();
        mav.setViewName("userRegister/studentReg");
        return mav;
    }

}
