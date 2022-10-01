package com.bean;

public class StudentDTO {

	private int stdID;
	private String StdName;
	private String mobile;
	private String email;
	
	
	private int courseId  ;
	private String courseName ;
	private int coursefee ;
	private int courseSeat;
	private String courseDuration;
	
	private int bid;
	private String bname;
	private String cName;
	private int TotalSeats;
	
	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDTO(int stdID, String stdName, String mobile, String email, int courseId, String courseName,
			int coursefee, int courseSeat, String courseDuration, int bid, String bname, String cName, int totalSeats) {
		super();
		this.stdID = stdID;
		StdName = stdName;
		this.mobile = mobile;
		this.email = email;
		this.courseId = courseId;
		this.courseName = courseName;
		this.coursefee = coursefee;
		this.courseSeat = courseSeat;
		this.courseDuration = courseDuration;
		this.bid = bid;
		this.bname = bname;
		this.cName = cName;
		TotalSeats = totalSeats;
	}
	
	public StudentDTO(int stdID, String stdName, String mobile, String email, int courseId, String courseName,
			int coursefee,  String courseDuration) {
		super();
		this.stdID = stdID;
		StdName = stdName;
		this.mobile = mobile;
		this.email = email;
		this.courseId = courseId;
		this.courseName = courseName;
		this.coursefee = coursefee;
		this.courseDuration = courseDuration;
	}

	public StudentDTO(int id, String name, String mobile2, String email2, int cid, String cname2, String cfee,
			String cdur) {
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

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
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

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getTotalSeats() {
		return TotalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		TotalSeats = totalSeats;
	}

	@Override
	public String toString() {
		return "StudentDTO [stdID=" + stdID + ", StdName=" + StdName + ", mobile=" + mobile + ", email=" + email
				+ ", courseId=" + courseId + ", courseName=" + courseName + ", coursefee=" + coursefee + ", courseSeat="
				+ courseSeat + ", courseDuration=" + courseDuration + ", bid=" + bid + ", bname=" + bname + ", cName="
				+ cName + ", TotalSeats=" + TotalSeats + "]";
	}

	
	
	
	
	
	
}

