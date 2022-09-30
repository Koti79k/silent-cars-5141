package com.UseCases;

import java.util.Scanner;

import com.DAO.StudentDao;
import com.DAO.StudentDaoImple;
import com.Exception.StudentException;
import com.bean.Student;


public class LoginUseCase {
	
	
	public static void main(String[] args) {
				
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Username:");
		String uname = sc.next();
		
		System.out.println("Enter Password:");
		String pass = sc.next();
		
		StudentDao dao = new StudentDaoImple();
		
		try {
			Student student= dao.loginStudent(uname, pass);
		
	 		System.out.println("Welcome Student :"+student.getStdName());	 	
	 	
		}catch (StudentException e) {
			System.out.println(e.getMessage());
		}
	
		
	}

}