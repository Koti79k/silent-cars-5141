package com.UseCases;

import java.util.List;


import com.DAO.StudentDao;
import com.DAO.StudentDaoImple;
import com.Exception.StudentException;
import com.bean.Student;

public class GetAllStudentUseCase {

	public static void main(String[] args) {

		StudentDao dao = new StudentDaoImple();

		try {
			List<Student> students = dao.getAllStudentDetails();

			students.forEach(s -> {

				System.out.println("Student Name :" + s.getStdName());
				System.out.println("Student email: " + s.getEmail());

				System.out.println("=======================");
			});

		} catch (StudentException se) {
			System.out.println(se.getMessage());
		}

	}

}
