package com.example.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name =  "inventory")
public class inventory {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "IProduct")
	private String IProduct;
	
	@Column(name = "count")
	private int count;
	
	@Column(name = "IDate")
	private String IDate;

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

	public String getIdate() {
		return IDate;
	}

	public void setIdate(String idate) {
		IDate = idate;
	}

	public inventory()
	{
		
	}
	public inventory(String iProduct, int count, String idate) {
		super();
		IProduct = iProduct;
		this.count = count;
		IDate = idate;
	}

}
