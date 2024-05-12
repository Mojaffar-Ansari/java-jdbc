package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDaw {
	public static boolean insertStudentToDB(Student st) {
		
		boolean insert = false;
		try {
			//jdbc code....
			Connection con = CP.createC();
			
			String q = "insert into students(sname,sphone,scity) values(?,?,?)";
			
			//PreparedStatement
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			//execute..
			pstmt.executeUpdate();
			insert = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return insert;
	}
	
	
	public static boolean deleteStudentFromDB(int sid) {
		boolean delete = false;
		try {
			//jdbc code....
			Connection con = CP.createC();
			
			String q = "delete from students where sid=?";
			
			//PreparedStatement
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, sid);
			
			//execute..
			pstmt.executeUpdate();
			delete = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return delete;
	}
	
	public static void displayAllStudentsFromDB() {
		
		try {
			//jdbc code....
			Connection con = CP.createC();
			
			String q = "select * from students";
			Statement stmt = con.createStatement();
			
			
			//execute..
			ResultSet set = stmt.executeQuery(q);
			
			while(set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString("scity");
				
				System.out.println("ID :"+id);
				System.out.println("Name :"+name);
				System.out.println("Phone :"+phone);
				System.out.println("City :"+city);
				
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean updateStudent(int sid, String name, String phone, String city) {
		
		boolean update = false;
		try {
			//jdbc code....
			Connection con = CP.createC();
			
			String q = "update students set sname =?,sphone=?,scity=? where sid=?";
			
			//PreparedStatement
			PreparedStatement pstmt = con.prepareStatement(q);
			
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, city);
			pstmt.setInt(4, sid);
			
			//execute..
			pstmt.executeUpdate();
			
			update = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return update;
	}
}
