package com.handson;

import java.io.Serializable;

public class Book  implements Serializable {

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", id=" + id + "]";
	}

	public String title;
	public double price;
	public int id;
	public Book(String title, double price, int id)
	{

		super();
		//setPrice(price);  

		this.title = title;
		this.price = price;
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {

		return price;
	}
	public void setPrice(double price)
	{


		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public void BookInfo()
	{
		System.out.println("title: "+title+" price: "+price+" id: "+id);
	}

}
