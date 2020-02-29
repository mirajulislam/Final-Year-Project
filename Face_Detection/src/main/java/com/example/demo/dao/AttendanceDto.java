package com.example.demo.dao;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class AttendanceDto {
	private Date attendanceDate;
	private int studentId;
	private int courseId;
	private int isAttendance;
	private String departmentShortName;
	 
	public AttendanceDto(Date attendanceDate, int studentId, int courseId, int isAttendance,
			String departmentShortName) {
		this.attendanceDate = attendanceDate;
		this.studentId = studentId;
		this.courseId = courseId;
		this.isAttendance = isAttendance;
		this.departmentShortName = departmentShortName;
	}

	public Date getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getIsAttendance() {
		return isAttendance;
	}

	public void setIsAttendance(int isAttendance) {
		this.isAttendance = isAttendance;
	}

	public String getDepartmentShortName() {
		return departmentShortName;
	}

	public void setDepartmentShortName(String departmentShortName) {
		this.departmentShortName = departmentShortName;
	}
	 
	 
}
