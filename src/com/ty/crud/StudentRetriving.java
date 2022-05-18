package com.ty.crud;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class StudentRetriving {
	public static void main(String args[]) {
		try {
			InputStream inputStream = new FileInputStream("chaipoint_db_info.properties");
			Properties properties = new Properties();
			properties.load(inputStream);

			String url = properties.getProperty("url");
			String driver = properties.getProperty("driver");

			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, properties);
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from student");
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String mail = rs.getString(3);
				
				System.out.println("Id is: "+id);
				System.out.println("Name is: "+name);
				System.out.println("Email is: "+mail);
				System.out.println("\n-----------------------------------------------------\n");
			}
			con.close();
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
