package com.UseCases;

import java.util.Scanner;

import com.DAO.StudentDao;
import com.DAO.StudentDaoImple;
import com.Exception.StudentException;
import com.bean.Student;


public class GetStudentUseCase1 {

	public static void main(String[] args) {
		
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Student Roll:");
		int roll= sc.nextInt();
		
		
		StudentDao dao= new StudentDaoImple();
		
		try {
		Student student= dao.getStudentByRoll(roll);
		
			System.out.println(student);
		
		}catch (StudentException se) {
			System.out.println(se.getMessage());
		}

		
		

	}

}
