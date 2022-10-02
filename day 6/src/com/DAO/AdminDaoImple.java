package com.DAO;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Exception.BranchException;
import com.Exception.CourseException;
import com.Exception.StudentException;
import com.bean.Batch;
import com.bean.Course;
import com.bean.Student;
import com.bean.StudentDTO;
import com.bean.StudentDTO1;
import com.mysql.cj.xdevapi.Statement;
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
/*============== Step 2: =====================*/
	@Override
	public String updateFee(String courseName, int coursefee) throws CourseException {
String msg="Course not found..";
		
		try {
			int id=Integer.parseInt(courseName);
			
			try(Connection conn=DButil.provideConnection()) {
				
				PreparedStatement ps= conn.prepareStatement("update course set coursefee=? where courseId=?");
				ps.setInt(1, coursefee);
				ps.setInt(2, id);
				
				int x=ps.executeUpdate();
				
				PreparedStatement ps1=conn.prepareStatement("select * from course where courseId=?");
				ps1.setInt(1, id);
				
				ResultSet rs=ps1.executeQuery();
				
				if(rs.next()) {
					System.out.println("Course id : "+ rs.getInt("courseId")+"---------- CourseName : "+rs.getString("CourseName")+
							"--------------- Current fee : "+ rs.getInt("coursefee"));
					
					msg="Course Fee Update Successfully.";
				}				
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			try(Connection conn=DButil.provideConnection()) {
				
				PreparedStatement ps= conn.prepareStatement("update course set coursefee=? where CourseName=?");
				ps.setInt(1, coursefee);
				ps.setString(2, courseName);
				
				int x=ps.executeUpdate();
				
				PreparedStatement ps1=conn.prepareStatement("select * from course where coursename=?");
				ps1.setString(1, courseName);
				
				ResultSet rs=ps1.executeQuery();
				
				if(rs.next()) {
					System.out.println("Course id : "+ rs.getInt("courseid")+"---------- CourseName : "+rs.getString("coursename")+
							"--------------- Current fee : "+ rs.getInt("coursefee"));
				}else throw new CourseException("Data not faund.");	
				
			} catch (SQLException bd) {
				throw new CourseException("Data not found..");
			}
		}
		
		return msg;
	}
	
	/*============== Step 3: =====================*/
	@Override
	public String DeleteCourse(String courseName) throws CourseException {
      String msg="Data not found.";
		
		try {
			try (Connection conn=DButil.provideConnection()){
				int id=Integer.parseInt(courseName);
				PreparedStatement ps=conn.prepareStatement("delete from course where courseid=?");
				ps.setInt(1, id);
				int x=ps.executeUpdate();
				
				if(x>0)msg="Delete Successfully..";
				else throw new CourseException("Data Not Found.");
				
			} catch (SQLException e) {
				throw new CourseException(e.getMessage());
			}
			
		} catch (Exception e) {
			try(Connection conn=DButil.provideConnection()) {
				
				PreparedStatement ps=conn.prepareStatement("delete from course where coursename=?");
				ps.setString(1, courseName);
				int x=ps.executeUpdate();
				
				if(x>0)msg="Delete Successfully..";
				else throw new CourseException("Data Not Found.");
				
			} catch (SQLException ss) {
				throw new CourseException(ss.getMessage());
			}
		}
		return msg;
	}
	/*============== Step 4: =====================*/
	@Override
	public Course searchInfo(String courseName) throws CourseException {
Course course=null;
		
		
		try {
			try(Connection conn=DButil.provideConnection())
			{
			    int id=Integer.parseInt(courseName);
				PreparedStatement ps=conn.prepareStatement("select * from course where courseid=?");
				ps.setInt(1, id);
			    ResultSet rs=ps.executeQuery();
				
			    if(rs.next()) 
			    {
					int courseid=rs.getInt("courseId");
					String coursename=rs.getString("courseName");
					int coursefee=rs.getInt("coursefee");
					int courseSeat=rs.getInt("courseSeat");
					String duration =rs.getString("courseDuration");
				
				     course=new Course(courseid, coursename, coursefee, courseSeat, duration);
			    }
			  else throw new CourseException("Data not found.");	
				
			} 
			catch (SQLException e) 
			{
				throw new CourseException("Data not found.");
			} 
		} catch (Exception e) {
			try(Connection conn=DButil.provideConnection())
			{
			  
				PreparedStatement ps=conn.prepareStatement("select * from course where coursename=?");
				ps.setString(1, courseName);
			    ResultSet rs=ps.executeQuery();
				
			    if(rs.next()) 
			    {
					int courseid=rs.getInt("courseid");
					String coursename=rs.getString("coursename");
					int coursefee=rs.getInt("coursefee");
					int courseSeat=rs.getInt("courseseat");
					String duration =rs.getString("courseDuration");
				
				     course=new Course(courseid, coursename, coursefee, courseSeat, duration);
			    }
			  else throw new CourseException("Data not found.");	
				
			} 
			catch (SQLException ss) 
			{
				throw new CourseException("data not found..");
			} 
		}
		
		return course;
	}
	/*============== Step 5: =====================*/
	@Override
	public String createNewBatch(Batch batch) throws BranchException {
		String message = "Not Inserted";

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("insert into batch(bname,cName,TotalSeats) values(?,?,?)");
			// We have to Bind the values
			ps.setString(1, batch.getBname());
			ps.setString(2, batch.getcName());
			ps.setInt(3, batch.getTotalSeats());

			int x = ps.executeUpdate();
			if (x > 0) {
				message = "Batch Registered Sucessfully..";
			}

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}
	
	
	/*============== Step 6: =====================*/
	@Override
	public String AlocateStudentBatch(String batchName, String CourseName, int courseid, int studentid)
			throws BranchException {
		String msg="please Enter data currectly.";
		boolean branchStatus = false;

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement cor = conn.prepareStatement("Select * from course where courseid=? and coursename=?");
			cor.setInt(1, courseid);
			cor.setString(2, CourseName);

			ResultSet rs = cor.executeQuery();

			if (rs.next()) {
				PreparedStatement std = conn.prepareStatement("Select * from student where stdid=?");
				std.setInt(1, studentid);

				ResultSet rs1 = std.executeQuery();
				if (rs1.next()) {

					branchStatus = true;

				} else
					throw new StudentException("Student id does't Exist ");

			} else
				throw new CourseException("Course id does not Exist");

			if (branchStatus) {

				PreparedStatement branch = conn.prepareStatement("insert into " + batchName + " values(?,?,?,?)");

				branch.setString(1, batchName);
				branch.setString(2, CourseName);
				branch.setInt(3, courseid);
				branch.setInt(4, studentid);
				

				branch.executeUpdate();
				msg = "Student Inserted  Successfully.";

			} else
				throw new BranchException("Batch already Exist..");

		} catch (Exception e) {
			msg = e.getMessage();
		}

		return msg;
	}
/*========================  Step 7  ================================*/
	
	@Override
	public String UpadateSeats(Batch batch) {
		String message="Not Inserted";
		// TODO Auto-generated method stub
		
		try(Connection conn= DButil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("update batch set TotalSeats=? where bid=?");
			
			
			
			ps.setInt(1,batch.getTotalSeats() );
			ps.setInt(2, batch.getBid());

			int x=ps.executeUpdate();
			
			
			if(x>0) {
				message="upadated Seat Sucessfully!...";
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			message=e.getMessage();
		}
		
	return message;
	}
	
/*============== Step 8: =====================*/

@Override
public List<StudentDTO> ViewAllStudentsOfBatch(String cname) throws CourseException {
	List<StudentDTO> dtos = new ArrayList<>();

	try (Connection conn = DButil.provideConnection()) {

		PreparedStatement ps = conn
				.prepareStatement("select s.stdID, s.Stdname,s.mobile,s.email, c.courseName, c.coursefee ,c.courseId,b.bid,b. TotalSeats from  student s INNER JOIN course c INNER JOIN batch b Inner Join Studentdto sd ON s.stdID = sd.stdID AND b.cname=? ");

		ps.setString(1,cname);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			int r = rs.getInt("stdID");
			String sn = rs.getString("Stdname");
			String sm = rs.getString("mobile");
			String em = rs.getString("email");
			
			String cn = rs.getString("courseName");
			String cf = rs.getString("coursefee");
			int ci = rs.getInt("courseId");
			int bi = rs.getInt("bid");
			int ts = rs.getInt("TotalSeats");
		
			
			StudentDTO dto =new StudentDTO(r, sn, sm, em, ci, cn, bi, ci, ts);

			dtos.add(dto);

		}

	} catch (SQLException e) {
		throw new CourseException(e.getMessage());
	}

	if (dtos.isEmpty())
		throw new CourseException("No Student found in that course");

	return dtos;
  }
}
	








