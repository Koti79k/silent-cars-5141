package com.bean;

public class StudentDTO1 {

	private int stdID;
	private String StdName;	
	private int courseId  ;
	private String courseName ;
	private int coursefee ;
	private int courseSeat;
	private String courseDuration;	
	private int bid;
	private String bname;

	
	public StudentDTO1() {
		super();
		// TODO Auto-generated constructor stub
	}


	public StudentDTO1(int stdID, String stdName, int courseId, String courseName, int coursefee, int courseSeat,
			String courseDuration, int bid, String bname) {
		super();
		this.stdID = stdID;
		StdName = stdName;
		this.courseId = courseId;
		this.courseName = courseName;
		this.coursefee = coursefee;
		this.courseSeat = courseSeat;
		this.courseDuration = courseDuration;
		this.bid = bid;
		this.bname = bname;
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
	
}


