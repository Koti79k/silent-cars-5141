package com.bean;

public class StudentDTO {

	private int stdID;
	private String Stdname;
	private String mobile;
	private String email;
	
	private String courseName;
	private int coursefee;
	private int courseSeat;
	private int courseDuration;
	
	public StudentDTO(int r, String sn, String sm, String em, String cn, int f) {
		// TODO Auto-generated constructor stub
	}

	public int getStdID() {
		return stdID;
	}

	public void setStdID(int stdID) {
		this.stdID = stdID;
	}

	public String getStdname() {
		return Stdname;
	}

	public void setStdname(String stdname) {
		Stdname = stdname;
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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCoursefee() {
		return coursefee;
	}

	public void setCoursefee(int coursefee) {
		this.coursefee = coursefee;
	}

	public int getCourseSeat() {
		return courseSeat;
	}

	public void setCourseSeat(int courseSeat) {
		this.courseSeat = courseSeat;
	}

	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}

	@Override
	public String toString() {
		return "StudentDTO [stdID=" + stdID + ", Stdname=" + Stdname + ", mobile=" + mobile + ", email=" + email
				+ ", courseName=" + courseName + ", coursefee=" + coursefee + ", courseSeat=" + courseSeat
				+ ", courseDuration=" + courseDuration + "]";
	}

	
	
	
	
	
}

