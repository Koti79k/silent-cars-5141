package com.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Exception.CourseException;
import com.Exception.StudentException;
import com.bean.Student;
import com.bean.StudentDTO;
import com.utility.DButil;

public class StudentDaoImple implements StudentDao {

	@Override
	public String registerStudent(String StdName, String mobile, String email, String password) {
		String message = "Not Inserted";

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("insert into student(StdName,Mobile,email,password) values(?,?,?,?)");
			// We have to Bind the values
			ps.setString(1, StdName);
			ps.setString(2, mobile);
			ps.setString(3, email);
			ps.setString(4, password);

			int x = ps.executeUpdate();
			if (x > 0) {
				message = "Student Registered Sucessfully..";
			}

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	/*
	 * == Second : This Is for Student object:We can use this method or above method
	 * for registration of student ==
	 */
	@Override
	public String registerStudent2(Student student) {
		String message = "Not Inserted";

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("insert into student(StdName,mobile,email,password) values(?,?,?,?)");
			// We have to Bind the values
			ps.setString(1, student.getStdName());
			ps.setString(2, student.getMobile());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getPassword());

			int x = ps.executeUpdate();
			if (x > 0) {
				message = "Student Registered Sucessfully..";
			}

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}
//Third:

	@Override
	public Student getStudentByRoll(int stdID) throws StudentException {
		Student student = null;

		try (Connection conn = DButil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from student where stdID=?");
			ps.setInt(1, stdID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int r = rs.getInt("stdID");
				String n = rs.getString("StdName");
				String m = rs.getString("mobile");
				String e = rs.getString("email");
				String p = rs.getString("password");

				student = new Student(r, n, m, e, p);
			} else {
				throw new StudentException("Student not Exist with stdID: " + stdID);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new StudentException(e.getMessage());
		}

		return student;
	}

	//===================== Fourth Step: For Login Student ==============================
	@Override
	public Student loginStudent(String username, String password) throws StudentException {
		Student student = null;
		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from student where email=? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int id=rs.getInt("stdID");
				String n=rs.getString("StdName");
				String m=rs.getString("mobile");
				String e=rs.getString("email");
				String p=rs.getString("password");
				
				student=new Student(id,n,m,e,p); 
			}
			else {
				throw new StudentException("Student Not Found");
			}
		} catch (SQLException e) {
			throw new StudentException(e.getMessage());
		}

		return student;
	}

// Fifth Step:
	@Override
	public List<Student> getAllStudentDetails() throws StudentException {
		List<Student> students = new ArrayList<>();
		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				int r = rs.getInt("stdID");
				String n = rs.getString("StdName");
				String m = rs.getString("mobile");
				String e = rs.getString("email");
				String p = rs.getString("password");

				Student student = new Student(r, n, m, e, p);
				students.add(student);
			}

		} catch (SQLException e) {
			throw new StudentException(e.getMessage());
		}
		if (students.size() == 0) {
			throw new StudentException("No Student Found");
		}

		return students;
	}

// 6th Step:
	@Override
	public String registerStudentInsideAcourse(int courseId, int stdID) throws StudentException, CourseException {
//	Student student=getStudentByRoll(roll);
		String message = "Not Registered";

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from student where stdID=?");
			ps.setInt(1, stdID);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				PreparedStatement ps2 = conn.prepareStatement("select * from course where courseId ?");
				ps2.setInt(1, courseId);
				ResultSet rs2 = ps2.executeQuery();

				if (rs2.next()) {
					PreparedStatement ps3 = conn.prepareStatement("insert into course_student values(?,?)");
					ps3.setInt(1, courseId);
					ps3.setInt(2, stdID);

					int x = ps3.executeUpdate();
					if (x > 0) {
						message = "Student Registered inside the Course Sucessfully..";

					} else {
						throw new StudentException("Technical Error..");
					}

				} else {
					throw new CourseException("Invalid Course...");
				}

			} else {
				throw new StudentException("Invalid Student..");
			}

		} catch (SQLException e) {
			throw new StudentException(e.getMessage());
		}

		return message;
	}

////======== 7th Step:
	@Override
	public List<StudentDTO> getAllAvailabiltyCourse(String cname) throws CourseException {

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

// ============8th step: Update Student Details
	@Override
	public String UpadateDeatails(Student student) {
		String message = "Not Inserted";

		try (Connection conn = DButil.provideConnection()) {
			PreparedStatement ps = conn
					.prepareStatement("update student set mobile=?,email=?,password=? where stdID=?");

			ps.setString(1, student.getMobile());
			ps.setString(2, student.getEmail());
			ps.setString(3, student.getPassword());
			ps.setInt(4, student.getStdID());

			int x = ps.executeUpdate();

			if (x > 0) {
				message = "upadated Sucessfully!...";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
//		e.printStackTrace();
			message = e.getMessage();
		}

		return message;

	}
}
