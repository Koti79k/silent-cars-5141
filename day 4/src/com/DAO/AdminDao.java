package com.DAO;

import com.Exception.BranchException;
import com.Exception.CourseException;
import com.bean.Student;
import com.bean.Course;

public interface AdminDao {
	public String AddNewCourse(int courseId, String courseName, int coursefee, int courseSeat, String courseDuration);
	
}
