package com.UseCases;

import java.util.Scanner;


import com.DAO.StudentDao;
import com.DAO.StudentDaoImple;

public class AllocateStudentToCourse {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the cid");
		int cid = sc.nextInt();

		System.out.println("Enter the roll");
		int roll = sc.nextInt();

		StudentDao dao = new StudentDaoImple();

		try {
			String result = dao.registerStudentInsideAcourse(cid, roll);

			System.out.println(result);
		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

	}

}
