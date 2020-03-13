package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Attendance;
@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer>{

	List<Attendance> findByAttendanceDateAndCourseCode(String attendanceDate,String courseCode);
	List<Attendance> findByAttendanceDateAndCourseCodeAndIsAttendance(String attendanceDate,String courseCode,String isAttendance);
}
