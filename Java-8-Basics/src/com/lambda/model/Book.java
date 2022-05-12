package com.lambda.model;

public class Book {

	private String name;
	private int price;
	
	public Book(String name, int price) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.price = price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	
	@Override
	public boolean equals(final Object obj) {
		if(obj == null) {
			return false;
		}
		final Book book = (Book) obj;
		if(this == book) {
			return true;
		} else {
			return (this.name.equals(book.getName()) && this.price == book.getPrice());
		}
	}
	@Override
	public int hashCode() {
		int hashNo = 7;
		hashNo = 13 * hashNo + (name == null ? 0 : name.hashCode());
		return hashNo;
	}
}
