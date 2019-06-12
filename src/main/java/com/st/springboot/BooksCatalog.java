package com.st.springboot;

import org.springframework.stereotype.Component;

@Component
public class BooksCatalog {
	private PythonBooks books;
	
	
	public BooksCatalog(PythonBooks books) {
		System.out.println("BooksCatalog : " + books);
		this.books = books; 
	}
	
	public void printBooks() {
		for(String b : books.getBooks())
			System.out.println(b);
	}
}
