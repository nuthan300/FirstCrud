package com.ty.crud;

public class ProductDataDriver {

	public static void main(String[] args) {

		ProductData productData = new ProductData();
		Product product = new Product();

		product.setBrand("HP");
		product.setCost(650.32);
		product.setId(11);
		product.setName("Mouse");
		product.setType("Electronics");

		productData.saveProduct(product);
	}
}
