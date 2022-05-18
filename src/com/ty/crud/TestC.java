package com.ty.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestC {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String user = "root";
		String password = "root";

		int[] id = { 1, 2, 3, 4, 5 };
		String name[] = { "mobile", "EarPhones", "book", "Shirt", "pant" };
		String brand[] = { "Samsung", "Boalt", "Classmate", "peter England", "Polo" };
		String type[] = { "Electronics", "Electronics", "Stationary", "Cloths", "Cloths" };
		double cost[] = { 22000.0, 2000.0, 100.50, 1500.56, 1200.36 };
		String query = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded.");

			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established");

			Statement stm = con.createStatement();
			int i = 4;
			while (i < 5) {
				query = "insert into Product values(" + id[i] + ",'" + name[i] + "','" + brand[i] + "','" + type[i]
						+ "'," + cost[i] + ")";
				stm.execute(query);
				i++;
				System.out.println("1 row Added.. ");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
