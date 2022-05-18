package com.ty.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentCrud {

	Connection con = ConnectionHelper.load();

	public void saveStudent(int id, String name, String mail) {
		try {
			Statement stm = con.createStatement();
			stm.execute("insert into student values(" + id + ",'" + name + "','" + mail + "')");
			con.close();
			System.out.println("1 row added..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteStudent(int id) {
		try {
			Statement stm = con.createStatement();
			stm.execute("delete from student where id =" + id);
			con.close();
			System.out.println("1 row Affected");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void printAllStudent() {
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from student");
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String mail = rs.getString(3);

				System.out.println("Id is: " + id);
				System.out.println("Name is: " + name);
				System.out.println("Email is: " + mail);
				System.out.println("\n-----------------------------------------------------\n");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void printStudentById(int id) {
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from student where id = " + id);
			if (rs.next()) {
				int rid = rs.getInt(1);
				String name = rs.getString(2);
				String mail = rs.getString(3);

				System.out.println("Id is: " + rid);
				System.out.println("Name is: " + name);
				System.out.println("Email is: " + mail);
				System.out.println("\n-----------------------------------------------------\n");
			} else
				System.out.println("No data found for given Id: " + id);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateStudentName(int id, String name) {
		try {
			Statement stm = con.createStatement();
			stm.execute("update student set name = '" + name + "' where id =" + id);
			con.close();
			System.out.println("Name is Successfully updated..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudentEmail(int id, String mail) {
		try {
			Statement stm = con.createStatement();
			stm.execute("update student set email = '" + mail + "' where id =" + id);
			con.close();
			System.out.println("Name is Successfully updated..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudent(int id, String name,String mail) {
		try {
			Statement stm = con.createStatement();
			stm.execute("update student set email = '" + mail + "', name = '"+name+"' where id =" + id);
			con.close();
			System.out.println("Name is Successfully updated..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
