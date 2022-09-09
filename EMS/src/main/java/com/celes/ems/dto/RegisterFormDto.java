package com.celes.ems.dto;

import javax.persistence.Entity;

@Entity
@javax.persistence.Table(name = "Register_Form")

public class RegisterFormDto {
	private String name;
	private String username;
	@javax.persistence.Id
	private String emailid;
	private String password;
	private String confirmpassword;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	@Override
	public String toString() {
		return "EmployeeDto [name=" + name + ", username=" + username + ", emailid=" + emailid + ", password="
				+ password + ", confirmpassword=" + confirmpassword + "]";
	}

}
