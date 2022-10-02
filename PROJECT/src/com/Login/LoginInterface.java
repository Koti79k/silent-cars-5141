package com.Login;

import com.Exception.AdminException;
import com.Exception.StudentException;
import com.bean.Admin;
import com.bean.Student;

public interface LoginInterface {
	public Admin loginAdmin(String email,String password) throws AdminException;
	public Student loginStudent(String email,String password) throws StudentException;
}
