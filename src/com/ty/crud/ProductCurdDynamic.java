package com.ty.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductCurdDynamic {
	Connection con = ConnectionHelper.load();

	public void insertProduct(int id, String name, String brand, String type, double price) {

		try {
			PreparedStatement pstm = con.prepareStatement("Insert into product values(?,?,?,?,?)");
			pstm.setInt(1, id);
			pstm.setString(2, name);
			pstm.setString(3, brand);
			pstm.setString(4, type);
			pstm.setDouble(5, price);
			pstm.execute();
			con.close();
			System.out.println("Data inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteProduct(int id) {
		try {
			PreparedStatement pstm = con.prepareStatement("Delete from product where id = ?");
			pstm.setInt(1, id);
			pstm.execute();
			con.close();
			System.out.println("1 row Affected");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateProductName(int id, String name) {
		try {
			PreparedStatement pstm = con.prepareStatement("Update product set name = ? where id = ?");
			pstm.setString(1, name);
			pstm.setInt(2, id);
			pstm.execute();
			con.close();
			System.out.println("Name is Successfully updated..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateProduct(int id, String name, String brand, String type, double price) {
		try {
			PreparedStatement pstm = con.prepareStatement("update student set brand = ?, name = ?, type = ?, cost = ? where id = ?");
			pstm.setString(1, brand);
			pstm.setString(2, name);
			pstm.setString(3, type);
			pstm.setDouble(4, price);
			pstm.execute();
			con.close();
			System.out.println("Product is Successfully updated..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void printProductById(int id) {
		try {
			PreparedStatement pstm = con.prepareStatement("select * from product where id = ?" );
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				int rid = rs.getInt(1);
				String name = rs.getString(2);
				String brand = rs.getString(3);
				String type = rs.getString(4);
				double cost = rs.getDouble(5);

				System.out.println("Id is: " + rid);
				System.out.println("Name is: " + name);
				System.out.println("Brand is: " + brand);
				System.out.println("Type is: "+ type);
				System.out.println("Cost is: "+ cost);
				System.out.println("\n-----------------------------------------------------\n");
			} else
				System.out.println("No data found for given Id: " + id);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void printAllProduct() {
		try {
			PreparedStatement pstm = con.prepareStatement("select * from product");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String brand = rs.getString(3);
				String type = rs.getString(4);
				double cost = rs.getDouble(5);

				System.out.println("Id is: " + id);
				System.out.println("Name is: " + name);
				System.out.println("Brand is: " + brand);
				System.out.println("Type is: "+ type);
				System.out.println("Cost is: "+ cost);
				System.out.println("\n-----------------------------------------------------\n");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
