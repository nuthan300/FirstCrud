package com.ty.crud;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.Properties;

public class ConnectionHelper {
	public static Connection load() {
		Connection con = null;
		try {
			InputStream inputStream = new FileInputStream("chaipoint_db_info.properties");
			Properties properties = new Properties();
			properties.load(inputStream);

			String url = properties.getProperty("url");
			String driver = properties.getProperty("driver");

			Class.forName(driver);
			con = DriverManager.getConnection(url, properties);
			/*Connection con = DriverManager.getConnection(url, properties);
			Statement stm = con.createStatement();

			stm.execute(query);
			con.close();*/
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
}
