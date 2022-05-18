package com.ty.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class TestE {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/javabatch?user=root&password=root";
		String query = "insert into user values (6,'Kumar','kumar@mail.com','kumar123',946785120)";
		
		try {
			DriverManager.registerDriver(new Driver());
			Connection con = DriverManager.getConnection(url);
			Statement stm = con.createStatement();
			
			stm.execute(query);
			System.out.println("Data Inserted..");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
