package com.UseCases;

import java.util.Scanner;
import com.DAO.StudentDao;
import com.DAO.StudentDaoImple;


public class RegisterStudentUseCase1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Student Name: ");
		String name=sc.next();
		
		System.out.println("Enter Student mobile: ");
		String mobile=sc.next();
		
		System.out.println("Enter Student Email: ");
		String email=sc.next();
		
		System.out.println("Enter Student Password: ");
		String password=sc.next();
		
		StudentDao dao=new StudentDaoImple(); //It has more flexibility compare to below code
//		StudentDaoImple dao=new StudentDaoImple();
		String result=dao.registerStudent(name,mobile, email, password);
		
		System.out.println(result);
		
	}
}

















