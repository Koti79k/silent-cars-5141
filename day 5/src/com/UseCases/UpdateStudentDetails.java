package com.UseCases;

import java.util.Scanner;
import com.DAO.StudentDao;
import com.DAO.StudentDaoImple;
import com.Exception.StudentException;
import com.bean.Student;

public class UpdateStudentDetails {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentDao st = new StudentDaoImple();

		System.out.println("Enter StudentID: ");
		int stdID = sc.nextInt();

		System.out.println("Enter New Mobile Number: ");
		String mobile = sc.next();

		System.out.println("Enter New Email: ");
		String Email = sc.next();

		System.out.println("Enter New Password: ");
		String Password = sc.next();

		Student std1 = new Student();

		std1.setStdID(stdID);
		std1.setMobile(mobile);
		std1.setEmail(Email);
		std1.setPassword(Password);

		String result = st.UpadateDeatails(std1);
		System.out.println(result);
	}
}
