package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;


import com.example.demo.model.Book;

@Repository
public class LibraryDAO {
	
	public static Connection connectToDB() {
		Connection connection = null;
		try {// Register the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Create Connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

}
	
	public ArrayList<Book> displaybook() {
		ArrayList<Book> bookList = new ArrayList<Book>();
		// TODO Auto-generated method stub
		try {
			Connection con = connectToDB();
			//Create Statement
			PreparedStatement stmt=con.prepareStatement("select * from books2");
			
			// Execute SQL query
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Book obj=new Book();
				obj.setBookId(rs.getInt(1));
				obj.setBookName(rs.getString(2));
				obj.setPrice(rs.getFloat(3));
				bookList.add(obj);
			}
	
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookList;
	}
	
	
	

public String getmessage() {
		
		return "Hello Everyone from DAO";
		
		}

public Book displaybookid(int bookId) {
	// TODO Auto-generated method stub
	Book obj=new Book();
	try {
		Connection con = connectToDB();
		//Create Statement
		PreparedStatement stmt=con.prepareStatement("select * from books2 where bookId=?");
		stmt.setInt(1,bookId);
		// Execute SQL query
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			
			obj.setBookId(rs.getInt(1));
			obj.setBookName(rs.getString(2));
			obj.setPrice(rs.getFloat(3));
			
		}

		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return obj;
}

public void addbook(Book obj) {
	// TODO Auto-generated method stub
			System.out.println(obj);
			
			try {
				Connection con = connectToDB();
				//Create Statement
				PreparedStatement stmt=con.prepareStatement("insert into books2 values(?,?,?)");
				stmt.setInt(1, obj.getBookId());
				stmt.setString(2, obj.getBookName());
				stmt.setFloat(3, obj.getPrice());
				// Execute SQL query
				int affectedrows = stmt.executeUpdate();
				System.out.println("Affected Rows = "+affectedrows);
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
}



}
