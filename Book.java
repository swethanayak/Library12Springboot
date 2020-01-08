package com.example.demo.model;

public class Book {
	
	
	private int bookId;
	private String bookName;
	private float price;
	 
 public Book(){
		
		System.out.println("Book Demo");
	}
	
	@Override
public String toString() {
	return "Book [bookId=" + bookId + ", bookName=" + bookName + ", price=" + price + "]";
}

	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

}
