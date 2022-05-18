package com.ty.crud;

public class ProductCurdDriver {
	public static void main(String[] args) {
		ProductCurdDynamic pcd = new ProductCurdDynamic();
		pcd.insertProduct(6, "Laptop", "Acer", "Electronics", 50000.00);
	}
}
