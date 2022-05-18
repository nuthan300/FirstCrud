package com.ty.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class Product1 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String user = "root";
		String password = "root";
		try {
			Driver d = new Driver();
			DriverManager.registerDriver(d);
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stm = con.createStatement();
			System.out.println(stm.execute("select * from product"));
			con.close();
			System.out.println("Data inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
