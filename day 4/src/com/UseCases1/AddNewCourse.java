package com.UseCases1;

import java.util.Scanner;

import com.DAO.AdminDao;
import com.DAO.AdminDaoImple;
import com.bean.Course;

public class AddNewCourse {
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter courseId: ");
		int cid=sc.nextInt();
		
		System.out.println("courseName: ");
		String courseName=sc.next();
		
		System.out.println("Enter coursefee: ");
		int cfee=sc.nextInt();
		
		System.out.println("Enter courseSeat: ");
		int cSeat=sc.nextInt();
		
		System.out.println("Enter courseDuration: ");
		String cDuration=sc.next();
		
		AdminDao dao=new AdminDaoImple();

        Course c1=new Course();
        c1.setCourseId(cid);
        c1.setCourseName(courseName);
        c1.setCoursefee(cfee);
        c1.setCourseSeat(cSeat);
        c1.setCourseDuration(cDuration);
		
		String result=dao.AddNewCourse(cid, courseName, cfee, cSeat, cDuration);
		System.out.println(result);
		
		
	}
}










