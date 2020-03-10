package com.example.demo.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Attendance;
import com.example.demo.model.Course;
import com.example.demo.model.CourseAssign;
import com.example.demo.model.Department;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.example.demo.model.TeacherCourseAssign;
import com.example.demo.repository.AttendanceRepository;
@Service
public class ViewService {
	
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private FindAllService findAllService;
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	public ModelAndView teacherReg() {   
		Teacher teacher=new Teacher();
        ModelAndView mav = new ModelAndView();
        mav.addObject("teacher", teacher);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        teacher=teacherService.findByUserName(auth.getName());
	    mav.addObject("userName", teacher.getFirstName()+" "+ teacher.getLastName()); 
        mav.setViewName("userRegister/teacherReg");
        return mav;
    }
	
	public ModelAndView studentReg() {     
        ModelAndView mav = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    Teacher teacher=teacherService.findByUserName(auth.getName());
	    mav.addObject("userName", teacher.getFirstName()+" "+ teacher.getLastName());        
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

	public ModelAndView courseInsert(Model model) {
		ModelAndView mav = new ModelAndView();
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    Teacher teacher=teacherService.findByUserName(auth.getName());
	    mav.addObject("userName", teacher.getFirstName()+" "+ teacher.getLastName());
		List<Department>departmentList=findAllService.listDepartment();
		model.addAttribute("departmentList",departmentList);
		mav.setViewName("register/course");
        return mav;
	}
	
	public ModelAndView departmentInsert() {
		ModelAndView mav = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    Teacher teacher=teacherService.findByUserName(auth.getName());
	    mav.addObject("userName", teacher.getFirstName()+" "+ teacher.getLastName());
		mav.setViewName("register/department");
        return mav;
	}
	
	public ModelAndView courseAssignInsert(Model model) {
		ModelAndView mav = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    Teacher teacher=teacherService.findByUserName(auth.getName());
	    mav.addObject("userName", teacher.getFirstName()+" "+ teacher.getLastName());		
		CourseAssign courseAssign=new CourseAssign();
		List<Student>studentList=findAllService.listStudent();
		List<Teacher>teacherList=findAllService.listTeacher();
		List<Course>courseList=findAllService.listCourse();
		List<Department>departmentList=findAllService.listDepartment();		
		mav.addObject("courseAssign", courseAssign);
		model.addAttribute("studentList",studentList);
		model.addAttribute("teacherList",teacherList);
		model.addAttribute("courseList",courseList);
		model.addAttribute("departmentList",departmentList);
		mav.setViewName("register/courseAssign");
        return mav;
	}
	
	public ModelAndView teacherCourseAssignInsert(Model model) {
		ModelAndView mav = new ModelAndView();
		TeacherCourseAssign teacherCourseAssign=new TeacherCourseAssign();
		List<Teacher>teacherList=findAllService.listTeacher();
		List<Course>courseList=findAllService.listCourse();
		List<Department>departmentList=findAllService.listDepartment();		
		mav.addObject("teacherCourseAssign", teacherCourseAssign);
		model.addAttribute("teacherList",teacherList);
		model.addAttribute("courseList",courseList);
		model.addAttribute("departmentList",departmentList);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    Teacher teacher=teacherService.findByUserName(auth.getName());
	    mav.addObject("userName", teacher.getFirstName()+" "+ teacher.getLastName());		
		mav.setViewName("register/teacherCourseAssign");
        return mav;
	}
	
	public ModelAndView searchAttendance(Model model) {
		ModelAndView mav = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    Teacher teacher=teacherService.findByUserName(auth.getName());
	    mav.addObject("userName", teacher.getFirstName()+" "+ teacher.getLastName());		
		Attendance attendance=new Attendance();
		List<Department> departMentList=findAllService.listDepartName();
		List<Course> courseCodeList=findAllService.listCourseCode();
		mav.addObject("attendance", attendance);
		model.addAttribute("departMentList",departMentList);
		model.addAttribute("courseCodeList",courseCodeList);
		mav.setViewName("attendance/AttendanceSearch");
		return mav;
		
	}
	
	public ModelAndView resutSearchAttendance(Model model,String attendanceDate, String courseCode) {
		ModelAndView mav = new ModelAndView();
		List<Attendance>attendanceResult=attendanceRepository.findByAttendanceDateAndCourseCode(attendanceDate, courseCode);
		model.addAttribute("attendanceResult",attendanceResult);
		mav.setViewName("attendance/AttendanceResult");
		return mav;		
	}
	
	public ModelAndView deleteAttendance(int id) {
		ModelAndView mav = new ModelAndView();
		findAllService.deleteAttendance(id);
		mav.setViewName("attendance/result");
		return mav;
		
	}
	
	public ModelAndView addAttendance(Model model) {
		Attendance attendance=new Attendance();
		List<Student>studentList=findAllService.listStudent();
        ModelAndView mav = new ModelAndView();
        mav.addObject("attendance", attendance);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    Teacher teacher=teacherService.findByUserName(auth.getName());
	    mav.addObject("userName", teacher.getFirstName()+" "+ teacher.getLastName());
        mav.setViewName("attendance/AddAttendance");
		List<Department> departMentList=findAllService.listDepartName();
		List<Course> courseCodeList=findAllService.listCourseCode();
		mav.addObject("attendance", attendance);
		model.addAttribute("departMentList",departMentList);
		model.addAttribute("courseCodeList",courseCodeList);
        model.addAttribute("studentList",studentList);		
        return mav;
	}
	
	public ModelAndView takeAtten() {   
        ModelAndView mav = new ModelAndView();
        mav.setViewName("attendance/TakeAttendance");
        return mav;
    }
	
	public ModelAndView takeAttenPhoto() {   
        ModelAndView mav = new ModelAndView();
        mav.setViewName("attendance/Take_Photo");
        return mav;
    }
}
