package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Book;
import com.example.demo.services.LibraryService;

@Controller
@ResponseBody
public class LibraryController {
	
	@Autowired
	LibraryService service;
	 
	@RequestMapping("/")
	public String getmessage() {
		
		return service.getmessage();
		
	}
	
	@RequestMapping("/display")
	public ArrayList<Book> display() {
		return service.display();
		
	}
	
	@RequestMapping("/displaybookid")
	public Book getbookid(@RequestParam("bookId") int bookId) {
		return service.getbookId(bookId);
		
	}
	
	/*@RequestMapping("/booksubmit")
	public  String addbook(@RequestParam("bookId") int bookId,@RequestParam("bookName") String bookName,@RequestParam("price") float price) {
		System.out.println("book details entered are " +bookId+"  "+bookName+"  "+price);
		Book obj=new Book();
		obj.setBookId(bookId);
		obj.setBookName(bookName);
		obj.setPrice(price);
		service.addbook(obj);
		return "Book successfully added";
	}*/
	
	@PostMapping("/addbook")
	public  String addbook(@RequestBody Book obj) {
		
		service.addbook(obj);
		return "Book successfully added";
	
	}
	
	
	
	
	
	@RequestMapping("/user")
	public String getUser() {
		return "All the details will be displayed here";
		
	}

}
