package com.ty.crud;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import com.mysql.cj.jdbc.Driver;

public class TestF {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String query = "insert into user values(7,'Prasanth HP','php@mail.com','prahp1236',968574320)";
		try {
			DriverManager.registerDriver(new Driver());
			Properties properties = new Properties();
			InputStream input = new FileInputStream("mydbinfo.properties");
			properties.load(input);
			
			Connection con = DriverManager.getConnection(url,properties);
			Statement stm = con.createStatement();
			stm.execute(query);
			con.close();
			System.out.println("Data Inserted");
		}
		catch(SQLException | IOException e) {
			e.printStackTrace();
		}
	}
}
