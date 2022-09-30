package com.UseCases;

import java.util.Scanner;


import com.DAO.StudentDao;
import com.DAO.StudentDaoImple;
import com.bean.Student;


public class RegisterStudentUseCase2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Student Name: ");
		String name=sc.next();
		
		System.out.println("Enter Student Mobile: ");
		String mobile=sc.next();
		
		System.out.println("Enter Student Email: ");
		String email=sc.next();
		
		System.out.println("Enter Student Password: ");
		String password=sc.next();
		
		StudentDao dao=new StudentDaoImple();
		
		Student student=new Student();
		student.setStdName(name);
		student.setMobile(mobile);
		student.setEmail(email);
		student.setPassword(password);
		
		String result= dao.registerStudent2(student);
		
		System.out.println(result);
		
	}
}

















