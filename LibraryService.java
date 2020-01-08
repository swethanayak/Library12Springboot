package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LibraryDAO;
import com.example.demo.model.Book;

@Service
public class LibraryService {
	@Autowired
	LibraryDAO dao;
public String getmessage() {
		

		return dao.getmessage();
		
		}
public ArrayList<Book> display() {
	// TODO Auto-generated method stub
	
	return dao.displaybook();
}
public Book getbookId(int bookId) {
	// TODO Auto-generated method stub
	return dao.displaybookid(bookId);
}
public void addbook(Book obj) {
	// TODO Auto-generated method stub
	dao.addbook(obj);
}
}
