package com.DAO;

import java.util.List;


import com.Exception.CourseException;
import com.Exception.StudentException;
import com.bean.Student;
import com.bean.StudentDTO;


public interface StudentDao {
//here only single single value passed
	public String registerStudent(String StdName,String mobile,String email,String password);

//encapsulate all data(name,email,password) into student object.This means it makes an object
// here we are registering student details as student object	
	public String registerStudent2(Student student);
	
	public Student getStudentByRoll(int stdID)throws StudentException ; //it take roll no. and give details of student
	
	public Student loginStudent(String username,String password) throws StudentException;
	
	public List<Student>getAllStudentDetails() throws StudentException;//It provide all details of table
	
	public String registerStudentInsideAcourse(int cid,int roll) throws StudentException,CourseException; //This is for course


	
	public List<StudentDTO> getAllStudentsByCname(String cname)throws CourseException;
	
	public String UpadateDeatails(Student student); //Update Student Details
	
	
}
