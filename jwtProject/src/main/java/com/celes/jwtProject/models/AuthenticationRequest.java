package com.celes.jwtProject.models;

public class AuthenticationRequest {
	private String username;
	private String pass;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public AuthenticationRequest() {
	}

	public AuthenticationRequest(String username, String pass) {
		super();
		this.username = username;
		this.pass = pass;
	}

}
