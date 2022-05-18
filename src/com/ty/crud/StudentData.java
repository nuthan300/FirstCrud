package com.ty.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentData {
	Connection con = ConnectionHelper.load();

	public List<Student> getStudent() {
		List<Student> list = new ArrayList<Student>();
		try {
			PreparedStatement preparedStatement = con.prepareStatement("Select * from student");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Student student = new Student();
				student.setId(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
				student.setEmail(resultSet.getString(3));
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}