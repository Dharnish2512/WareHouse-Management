package com.example.springboot.web.dto;

public class inventorymanagementDto {
	private String IProduct;
	private int count;
	private String IDate;
	public inventorymanagementDto() {
		
	}
	public inventorymanagementDto(String iProduct, int count, String iDate) {
		super();
		IProduct = iProduct;
		this.count = count;
		IDate = iDate;
	}
	public String getIProduct() {
		return IProduct;
	}
	public void setIProduct(String iProduct) {
		IProduct = iProduct;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getIDate() {
		return IDate;
	}
	public void setIDate(String iDate) {
		IDate = iDate;
	}
	

}
