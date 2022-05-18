package com.ty.crud;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TestG {

	public static void main(String[] args) {
		try {
			InputStream inputStream = new FileInputStream("chaipoint_db_info.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			String url = properties.getProperty("url");
			String driver = properties.getProperty("driver");
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, properties);
			Statement stm = con.createStatement();
			stm.execute("insert into student values (1,'Prasanth H.P','php@mail.com')");
			System.out.println("Data Inserted");
			con.close();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}
}
