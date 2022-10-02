package com.Main_UseCases;

import java.util.Scanner;

import com.Exception.AdminException;
import com.Exception.StudentException;
import com.Login.LoginMethod;
import com.bean.Admin;
import com.bean.Student;


public class Login {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		LoginMethod lm=new LoginMethod();
		
//		LoginInterface runAdmin=new LoginMethod();
		Demo std=new Demo();
		
		boolean status=true;
		
		while(status) {
			System.out.println("Welcome To Automated Student Registration System");
			System.out.println("Choose Option...");
			System.out.println("  1. Admin Login.\r\n"
					+ "  2. Student Login.\r\n"
					+ "  3. Exit.");
			
			int num=sc.nextInt();
			
			switch (num) {
				case 1: {
					System.out.println("Admin Login.");
					
					System.out.print("Enter admin Email Id : ");
					String email=sc.next();
					
					System.out.print("Enter Admin Password : ");
					String password=sc.next();
					
					try {
						Admin ad=lm.loginAdmin(email, password);
						System.out.println("Welcome "+ad.getAdminName());
						
					} catch (AdminException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				break;
				}
				
				case 2:{
					System.out.println("Student Login.");
					
					System.out.print("Enter Student Email Id : ");
					String email=sc.next();
					
					System.out.print("Enter Student Password : ");
					String password=sc.next();
				
						try {
							Student st=lm.loginStudent(email, password);
							System.out.println("Welcome  "+st.getStdName());
							
						} catch (StudentException e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
						}
						break;
				}
				case 3: {
					System.out.println("Thank You.");
					status=false;
					break;
					
				}
			default:System.out.println("please Enter Valid Number.");
			}
			
		}
	}

}
