package com.Main;

import java.util.List;
import java.util.Scanner;

import com.DAO.AdminDao;
import com.DAO.AdminDaoImple;
import com.DAO.StudentDao;
import com.DAO.StudentDaoImple;
import com.Exception.BranchException;
import com.Exception.CourseException;
import com.bean.Batch;
import com.bean.Course;
import com.bean.StudentDTO;

public class AdminUsses {
	
	public static void administarRun() {
		Scanner sc= new Scanner(System.in);
		AdminDaoImple all= new AdminDaoImple();
		
		boolean status=true;
		
		while(status) {
			System.out.println("\n Choose Option only press Number.. \n");
			System.out.println("  1. Add a new Courses\r\n"
					+ "  2. Update Fees of course.\r\n"
					+ "  3. Delete  a course from any Training session.\r\n"
					+ "  4. Search information about a course.\r\n"
					+ "  5. Create Batch under a course.\r\n"
					+ "  6. Allocate students in a Batch under a course.\r\n"
					+ "  7. Update total seats of a batch.\r\n"
					+ "  8. View the students of every batch.\r\n"
					+ "  9. Exit for Admin.");
			System.out.println("=================================================== \n");
			int num=sc.nextInt();
			
			switch (num) {
			case 1: {
				System.out.println("Add a new Course. \n");

				System.out.print("Enter course id : ");
				int id = sc.nextInt();

				System.out.print("Enter course Name : ");
				String name = sc.next();

				System.out.print("Enter Course fee : ");
				int fee = sc.nextInt();

				System.out.print("Enter course seat : ");
				int seats = sc.nextInt();

				System.out.print("Enter course Durtion : ");
				String duration = sc.next();

				String msg = all.AddNewCourse(id, name, fee, seats, duration);
				System.out.println(msg);

				System.out.println("===========================================");

			}
				break;

			case 2: {
				System.out.println("update fee course.");

				System.out.print("Enter course Name : ");
				String name = sc.next();

				System.out.print("Enter Course fee : ");
				int fee = sc.nextInt();

				try {
					String msg = all.updateFee(name, fee);
					System.out.println("fees updated sucessfully");
				} catch (CourseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("===========================================");
			}
				break;

			case 3: {
				System.out.println("Delete  a course from any Training session");

				System.out.print("Enter course name or id : ");
				String name = sc.next();

				try {
					String msg = all.DeleteCourse(name);
					System.out.println(msg);
				} catch (CourseException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				System.out.println("===========================================");
			}
				break;
			case 4: {
				System.out.println("Search information about a course");

				System.out.print("Enter course name or id : ");
				String name = sc.next();

				try {
					Course course = all.searchInfo(name);
					System.out.println(course);
				} catch (CourseException e) {
					// TODO Auto-generated catch block
//				System.out.println(e.getMessage());
					System.out.println(e.getMessage());
				}
				System.out.println("===========================================");
			}
				break;

			case 5: {
				System.out.println("Create Batch under a course.");
				System.out.println("How many Batch Created.");
				int bat = sc.nextInt();
				int i = 1;
				while (bat > 0) {
					System.out.println("Enter Data of Batch no : " + i++);
					System.out.print("Enetr Batch Name : ");
					String bname = sc.next();

					System.out.print("Enetr Course Name : ");
					String cName = sc.next();

					System.out.println("Enter TotalSeats: ");
					int TotalSeats = sc.nextInt();

					AdminDao dao = new AdminDaoImple();

					Batch b1 = new Batch();
					b1.setBname(bname);
					b1.setcName(cName);
					b1.setTotalSeats(TotalSeats);

					String result = null;
					try {
						result = dao.createNewBatch(b1);
					} catch (BranchException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					System.out.println(result);

					System.out.println("==========================================");
					bat--;
				}
			}
				break;

			case 6: {
				System.out.println(" Allocate students in a Batch under a course");

				System.out.print("Enetr Batch Name : ");
				String batch = sc.next();
				System.out.print("Enetr Course Name : ");
				String course = sc.next();
				System.out.print("Enter course id : ");
				int corid = sc.nextInt();
				System.out.print("Enter Student id : ");
				int stdid = sc.nextInt();

				String ss = null;
				try {
					ss = all.AlocateStudentBatch(batch, course, corid, stdid);
				} catch (BranchException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(ss);
				System.out.println("==========================================");

			}
				break;
			case 7: {
				System.out.println("Update total seats of a batch.");

				System.out.println("Enter Batch Id");
				int bid = sc.nextInt();

				System.out.println("Modify the seats In Batch");
				int seat = sc.nextInt();

				AdminDao dao = new AdminDaoImple();

				Batch update = new Batch();
				update.setBid(bid);
				update.setTotalSeats(seat);

				String result = dao.UpadateSeats(update);

				System.out.println(result);

				System.out.println("===========================================");

			}
				break;
			case 8: {
				System.out.println("View the students of every batch");

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
//	              System.out.println("Enter Course Name: ");
//	              String bn=sc.next();
//	              
//	              AdminDao d=new AdminDaoImple();
//	              try {
//					List<StudentDTO1> list=d.viewAllStudent(bn);
//					list.forEach(b->{
//						System.out.println("Student ID:"+b.getStdID());
//						System.out.println("Student Name :"+b.getStdName());
//						System.out.println("Course ID :"+b.getCourseId());
//						System.out.println("Course Name :"+b.getCourseId());
//						System.out.println("Course Fee :"+b.getCourseId());
//						System.out.println("Course Seat :"+b.getCourseId());
//						System.out.println("Course Duration :"+b.getCourseId());
//						System.out.println("Batch ID :"+b.getBid());
//						System.out.println("Batch Name :"+b.getBname());
//						System.out.println("===========================================");
//					});

			}
				break;
			case 9: {
				System.out.println("Admin Logout.");
				status = false;
				break;
			}
			default:
				System.out.println("Plese Enter valid Number...");
			}

		}
	}
}

