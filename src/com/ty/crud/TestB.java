package com.ty.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestB {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/javabatch";
		String user = "root";
		String password = "root";

		String query = "Delete from student where id = 1";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded..");
			
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println(con);
			
			Statement stm = con.createStatement();
			stm.execute(query);
			System.out.println("Data deleted");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
