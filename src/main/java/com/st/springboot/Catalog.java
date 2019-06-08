package com.st.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component 
public class Catalog {
	@Autowired
	Books books;
	
	public Catalog() {
		System.out.println("Catalog created!");
	}

	public Books getBooks() {
		return books;
	}

	public void setBooks(Books books) {
		System.out.println("setting books ->" + books);
		this.books = books;
	}
	
	public void print() {
		System.out.println(books);
		for(String b : books.getBooks())
			System.out.println(b);
	}

}
