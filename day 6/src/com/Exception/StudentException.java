package com.Exception;

public class StudentException extends Exception{ // it is checked exception
  //for making unchecked we use RuntimeException instead of Exception  
	public StudentException() {  //1st constructor
		// TODO Auto-generated constructor stub
	}
	
	public StudentException(String message){  //2nd constructor
		super(message);
	}
}
