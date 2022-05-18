package com.ty.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestA {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/javabatch";
		String userName = "root";
		String password = "root";
		
		String query = "insert into javabatch.student values(6,'Prasanth B.P','pbp@mail.com')";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded..");
			
			Connection con = DriverManager.getConnection(url, userName, password);
			System.out.println(con);
			
			Statement stm = con.createStatement();
			stm.execute(query);
			System.out.println("Data inserted");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}