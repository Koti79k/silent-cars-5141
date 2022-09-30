package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.utility.DButil;

public class AdminDaoImple implements AdminDao{

	@Override
	public String AddNewCourse(int courseId, String courseName, int coursefee, int courseSeat, String courseDuration) {
		String msg="Data not Inserted !!";
		
		try (Connection conn=DButil.provideConnection()){
			
		PreparedStatement ps=	conn.prepareCall("insert into course values(?,?,?,?,?)");
			
		ps.setInt(1, courseId);
		ps.setString(2, courseName);
		ps.setInt(3, coursefee);
		ps.setInt(4, courseSeat);
		ps.setString(5, courseDuration);
		
		int x= ps.executeUpdate();
		
		if(x>0)msg="Data Inserted Successfully.";
			
		} catch (SQLException e) {
			msg=e.getMessage();
		}
		return msg;
	}

	
	
}