package com.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Exception.AdminException;
import com.Exception.StudentException;
import com.bean.Admin;
import com.bean.Student;
import com.utility.DButil;

public class LoginMethod implements LoginInterface{

	@Override
	public Admin loginAdmin(String email, String password) throws AdminException {
		Admin admin=null;
		
		try(Connection conn=DButil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from administar where adminemail=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			
		ResultSet rs=	ps.executeQuery();
		
		if(rs.next()) {
			int adminId=rs.getInt("AdminId");
			String AdminName=rs.getString("AdminName");
			String adminemail=rs.getString("AdminEmail");
			String adminMobile=rs.getString("adminMobile");
			
			admin=new Admin(adminId, AdminName, adminemail, adminMobile);
			
		}else throw new AdminException("Email or password does't Exit.");
			
		} catch (SQLException e) {
			throw new AdminException("Email or password does't Exit.");
		}
		return admin;
	}

	@Override
	public Student loginStudent(String email, String password) throws StudentException {
		Student student=null;
		
		try(Connection conn=DButil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from student where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			
		ResultSet rs=	ps.executeQuery();
		
		if(rs.next()) {
			
			int studentId=rs.getInt("stdid");
			String studentName=rs.getString("stdname");
			String address=rs.getString("address");
			String studentmail=rs.getString("email");
			String studentMobile=rs.getString("mobile");
			
			student= new Student(studentId, studentName, address, studentmail, studentMobile);
			
		}else throw new StudentException("Email or password does't Exit.");
			
		} catch (SQLException e) {
			throw new StudentException("Email or password does't Exit.");
		}
		return student;
	}

}
