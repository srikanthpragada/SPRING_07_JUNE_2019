package com.st.springboot;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component 
public class Catalog {
	Books books;
	
	public Catalog() {
		System.out.println("Catalog created!" + books);
	}
	
	@PostConstruct 
	public void init() {
		System.out.println("Catalog PostConstruct!" + books);
	}

	public Books getBooks() {
		return books;
	}
	
	@Autowired
	@Qualifier("python")
	public void setBooks(Books books) {
		System.out.println("setting books ->" + books);
		this.books = books;
	}
	
	public void print() {
		for(String b : books.getBooks())
			System.out.println(b);
	}

}
