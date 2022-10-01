package com.Main_UseCases;

import java.util.List;

import java.util.Scanner;

import com.DAO.AdminDao;
import com.DAO.AdminDaoImple;
import com.DAO.StudentDao;
import com.DAO.StudentDaoImple;
import com.Exception.BranchException;
import com.Exception.CourseException;
import com.Exception.StudentException;
import com.bean.Batch;
import com.bean.Course;
import com.bean.Student;
import com.bean.StudentDTO;

public class Demo {
	public static void main(String[] args) throws StudentException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Automated-Student-Registration-System Who you are ");

		System.out.println("1.Admin");
		System.out.println("2.Student");
		int ans = sc.nextInt();

		// Here Page Starts
		if (ans == 1) {
			System.out.println("Login as Admin");
			System.out.println("Enter username");
			String user = sc.next();
			System.out.println("Enter password");
			String pass = sc.next();

			AdminDao all = new AdminDaoImple();
			boolean status = true;

			while (status) {
				System.out.println("\n Choose Option only press Number.. \n");
				System.out.println("  1. Add a new Courses\r\n" + "  2. Update Fees of course.\r\n"
						+ "  3. Delete  a course from any Training session.\r\n"
						+ "  4. Search information about a course.\r\n" 
						+ "  5. Create Batch under a course.\r\n"
						+ "  6. Allocate students in a Batch under a course.\r\n"
						+ "  7. Update total seats of a batch.\r\n" 
						+ "  8. View the students of every batch.\r\n"
						+ "  9. Exit for Admin.");
				System.out.println("=================================================== \n");
				int num = sc.nextInt();

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
//					System.out.println(e.getMessage());
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
						int TotalSeats=sc.nextInt();

						AdminDao dao=new AdminDaoImple();
						
						Batch b1=new Batch();
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
					String batch=sc.next();
					System.out.print("Enetr Course Name : ");
					String course=sc.next();
					System.out.print("Enter course id : ");
					int corid=sc.nextInt();
					System.out.print("Enter Student id : ");
					int stdid=sc.nextInt();
					
				
					
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
					int bid =sc.nextInt();
					
					System.out.println("Modify the seats In Batch");
					int seat =sc.nextInt();
					
					AdminDao dao =new AdminDaoImple();
					
			        Batch update = new  Batch();
					update.setBid(bid);
					update.setTotalSeats(seat);
					
				
					String result = dao.UpadateSeats(update);

					
					System.out.println(result);
					
				

					System.out.println("===========================================");
					

				}
					break;
				case 8: {
					System.out.println("View the students of every batch");
					
					System.out.print("Enter Student ID : ");
					String course=sc.next();
					System.out.print("Enter Course ID : ");
					String name=sc.next();
					
//					try {
//					StudentDTO std=	all.viewAllStudent(num, ans);
//					System.out.println(std);
//					} catch (BranchException e) {
//						// TODO Auto-generated catch block
//						System.out.println(e.getMessage());
//					}
					
					AdminDao dao = new AdminDaoImple();
					try {
						List<StudentDTO> students =dao.viewAllStudent(ans, num);
						
						students.forEach(s -> {

							System.out.println("Course Id :"+s.getCid());
							System.out.println("Course Name: "+s.getCname());
							System.out.println("Course Fees: "+s.getFees());
//							

							System.out.println("=======================");
						});
						
					} catch (BranchException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
//					AllMethodInterface dao =new MethodImp();
//					
//					Administrator administrator=new Administrator();
//						
//						try {
//							List<Administrator> administrators= dao.getCourseDetails();
//							
//							administrators.forEach(s ->{
//								
//								System.out.println("Course Id :"+s.getCid());
//								System.out.println("Course Name: "+s.getCname());
//								System.out.println("Course Fees: "+s.getFees());
//								
//								System.out.println("=======================");
//							});
//							
//							
//							
//						} catch (CourseException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//							System.out.println(e.getMessage());
//						}

					}
					
					
					System.out.println("=========================================== \n");
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
		// ======================= Here Student Page Starts ================================

		else if (ans == 2) {
			System.out.println("Login as Student");
			System.out.println("Enter email here");
			String email = sc.next();
			System.out.println("Enter password here");
			String pass = sc.next();

boolean status = true;
			while (status) {

				System.out.println("Welecome Student Page");
				System.out.println("1. Register himself in a course with a username and password \r\n"
						+ "	2. can update this details.\r\n"
						+ "	3. can see all the available course list and their seat availability.\r\n"
						+ " 4. Student Exit.\r\n");

				System.out.println("=================================================== \n");
				int num = sc.nextInt();

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
					/* Case 3 Pending */
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
}
