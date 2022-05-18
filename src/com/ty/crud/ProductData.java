package com.ty.crud;

public class ProductData {
	
	public void saveProduct(Product product) {
		
		System.out.println("Id: " + product.getId());
		System.out.println("Name: " + product.getName());
		System.out.println("Brand: " + product.getBrand());
		System.out.println("Type: "+ product.getType());
		System.out.println("Cost: "+ product.getCost());
	}
}
