package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teaacher_course_assign")
public class TeacherCourseAssign {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int teacherId;
	private String courseCode;
	private String departmentShortName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getDepartmentShortName() {
		return departmentShortName;
	}
	public void setDepartmentShortName(String departmentShortName) {
		this.departmentShortName = departmentShortName;
	}
	
	

}
