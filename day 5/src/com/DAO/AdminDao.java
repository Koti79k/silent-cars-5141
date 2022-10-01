package com.DAO;

import java.util.List;

import com.Exception.BranchException;
import com.Exception.CourseException;
import com.bean.Student;
import com.bean.StudentDTO;
import com.bean.Batch;
import com.bean.Course;

public interface AdminDao {
	public String AddNewCourse(int courseId, String courseName, int coursefee, int courseSeat, String courseDuration);
	public String updateFee(String courseName,int coursefee) throws CourseException;
	public String DeleteCourse(String courseName) throws CourseException;
	public Course searchInfo(String courseName)throws CourseException;
	
	public String createNewBatch(Batch batch)throws BranchException;
	public String AlocateStudentBatch(String batchName,String CourseName,int courseid,int studentid)throws BranchException;
	public String UpadateSeats(Batch batch);
	public List<StudentDTO> viewAllStudent(int stdID,int courseid)throws BranchException;
	
	
}
