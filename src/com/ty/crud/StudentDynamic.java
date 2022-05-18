package com.ty.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDynamic {

	Connection con = ConnectionHelper.load();

	public void saveStudent(int id, String name, String email) {

		try {
			PreparedStatement pstm = con.prepareStatement("Insert into student values(?,?,?)");
			pstm.setInt(1, id);
			pstm.setString(2, name);
			pstm.setString(3, email);
			pstm.execute();
			con.close();
			System.out.println("Data inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteStudent(int id) {
		try {
			PreparedStatement pstm = con.prepareStatement("Delete from student where id = ?");
			pstm.setInt(1, id);
			pstm.execute();
			con.close();
			System.out.println("1 row Affected");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudentName(int id, String name) {
		try {
			PreparedStatement pstm = con.prepareStatement("Update student set name = ? where id = ?");
			pstm.setString(1, name);
			pstm.setInt(2, id);
			pstm.execute();
			con.close();
			System.out.println("Name is Successfully updated..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudent(int id, String name,String mail) {
		try {
			PreparedStatement pstm = con.prepareStatement("update student set email = ?, name = ? where id = ?");
			pstm.setString(1, mail);
			pstm.setString(2, name);
			pstm.setInt(3, id);
			pstm.execute();
			con.close();
			System.out.println("Student is Successfully updated..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void printStudentById(int id) {
		try {
			PreparedStatement pstm = con.prepareStatement("select * from student where id = ?" );
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
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
	
	public void printAllStudent() {
		try {
			PreparedStatement pstm = con.prepareStatement("select * from student");
			ResultSet rs = pstm.executeQuery();
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
}
