package com.bean;

public class Course {

	private int courseId  ;
	private String courseName ;
	private int coursefee ;
	private int courseSeat;
	private String courseDuration;
	
	
	public Course(int courseId, String courseName, int coursefee, int courseSeat, String courseDuration) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.coursefee = coursefee;
		this.courseSeat = courseSeat;
		this.courseDuration = courseDuration;
	}
	
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
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
	@Override
	public String toString() {
		return "course [courseId=" + courseId + ", courseName=" + courseName + ", coursefee=" + coursefee
				+ ", courseSeat=" + courseSeat + ", courseDuration=" + courseDuration + "]";
	}
	
}
