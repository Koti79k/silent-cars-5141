package com.utility;

import java.sql.Connection;

public class Checking_Connection {
 public static void main(String[] args) {
	Connection conn=DButil.provideConnection();
	System.out.println(conn);
}
}
