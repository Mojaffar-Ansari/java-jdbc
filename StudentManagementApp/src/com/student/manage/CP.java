package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
	
	static Connection con;
	
	public static Connection createC() {
		try {
			//load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//creat connection
			String user = "root";
			String password = "Admin@1997#";
			String url = "jdbc:mysql://localhost:3306/student_manage";
			
			con = DriverManager.getConnection(url,user,password);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return con;
	}
}
