package com.ty.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestD {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String user = "root";
		String password = "root";

		int[] id = { 1, 2, 3, 4, 5 };
		String name[] = { "Chetan", "Nuthan", "Balaji", "Prashanth", "pavan" };
		String email[] = { "Chetan@mail.com", "nuthan@mail.com", "balaji@mail.com", "prasanth@mail.com", "pavan@mail.com" };
		String pwd[] = { "chethan123", "nuthan456", "balaji789", "prashanth1011", "balaji1213" };
		int mobile[] = { 963852741, 987654321, 951736824, 946130758, 907381624 };
		String query = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded.");

			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established");

			Statement stm = con.createStatement();
			int i = 0;
			while (i < 5) {
				query = "insert into User values(" + id[i] + ",'" + name[i] + "','" + email[i] + "','" + pwd[i]
						+ "'," + mobile[i] + ")";
				stm.execute(query);
				i++;
				System.out.println("1 row Added.. ");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
