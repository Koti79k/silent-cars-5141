package com.bean;

public class Student {
	
	private int stdID;
	private String StdName;
	private String mobile;
	private String email;
	private String password;
	
	public Student(int r, String n, String m, String e, String p) {
		// TODO Auto-generated constructor stub
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}



	public int getStdID() {
		return stdID;
	}

	public void setStdID(int stdID) {
		this.stdID = stdID;
	}

	public String getStdName() {
		return StdName;
	}

	public void setStdName(String stdName) {
		StdName = stdName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [stdID=" + stdID + ", StdName=" + StdName + ", mobile=" + mobile + ", email=" + email
				+ ", password=" + password + "]";
	}

	
	


	
	

}