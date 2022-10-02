package com.Main;

import java.util.List;
import java.util.Scanner;

import com.DAO.StudentDao;
import com.DAO.StudentDaoImple;
import com.Exception.CourseException;
import com.bean.Student;
import com.bean.StudentDTO;

public class StudentUseCase {
	
	public static void StudentRun() {
		Scanner sc= new Scanner(System.in);
		StudentDao stm= new StudentDaoImple();
		
		boolean status = true;
		
		while(status) {
			System.out.println("\n Choose Option only press Number.. \n");
			System.out.println("         1. Register himself in a course with a username and password \r\n"
					+ "	2. can update this details.\r\n"
					+ "	3. can see all the available course list and their seat availability.\r\n"
					+ "         4. Student Exit.\r\n");
			
			System.out.println("=================================================== \n");
			int num=sc.nextInt();
			
			switch (num) {
			case 1: {
				System.out.println("Register himself in a course with a username and password ");

				System.out.println("Enter Student Name: ");
				String name = sc.next();

				System.out.println("Enter Student Mobile: ");
				String mobile = sc.next();

				System.out.println("Enter Student Email: ");
				String email1 = sc.next();

				System.out.println("Enter Student Password: ");
				String password = sc.next();

				StudentDao dao = new StudentDaoImple();

				Student student = new Student();
				student.setStdName(name);
				student.setMobile(mobile);
				student.setEmail(email1);
				student.setPassword(password);

				String result = dao.registerStudent2(student);
				System.out.println(result);

			}
				break;
			case 2: {
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

				StudentDao st = new StudentDaoImple();
				String result = st.UpadateDeatails(std1);
				System.out.println(result);
			}
				break;
			/*
			 * ======================== Case 3
			 * :===================================================
			 */
			case 3: {
				System.out.println("avilable Couse");

				System.out.println("Enter Course Name");
				String cname = sc.next();

				StudentDao dao = new StudentDaoImple();

				StudentDTO studentDTO = new StudentDTO();

				try {
					List<StudentDTO> studentDTOs = dao.getAllAvailabiltyCourse(cname);

					studentDTOs.forEach(c -> {

						System.out.println("Course ID :" + c.getCourseId());
						System.out.println("Course Name :" + c.getCourseName());
						System.out.println("Course Fees :" + c.getCoursefee());
						System.out.println("Student stdID :" + c.getStdID());
						System.out.println("Student User Name :" + c.getEmail());
						System.out.println("Student Name :" + c.getStdName());
						System.out.println("Student Mobile :" + c.getMobile());
						System.out.println("=========================================");
					});

				} catch (CourseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e.getMessage());
				}

			}
				
/* ========================================= CASE 4: =================================== */
				
				break;
			case 4: {
				System.out.println("Student Logout..");
				status = false;
			}
				break;
			default:
				System.out.println("Enter Valid Number.");
			}
		}
	}

}

