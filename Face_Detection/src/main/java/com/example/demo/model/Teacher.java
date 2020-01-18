package com.example.demo.model;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "create_teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacherId;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private String department;
	private String password;
	
	private Date tx_created_date;
    private Date tx_update_date;
    private Date tx_deleteDate;
	
    @ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "teacher_role", joinColumns = @JoinColumn(name = "teacher_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getTx_created_date() {
		return tx_created_date;
	}
	public void setTx_created_date(Date tx_created_date) {
		this.tx_created_date = tx_created_date;
	}
	public Date getTx_update_date() {
		return tx_update_date;
	}
	public void setTx_update_date(Date tx_update_date) {
		this.tx_update_date = tx_update_date;
	}
	public Date getTx_deleteDate() {
		return tx_deleteDate;
	}
	public void setTx_deleteDate(Date tx_deleteDate) {
		this.tx_deleteDate = tx_deleteDate;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	

}
