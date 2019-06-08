package com.st.springboot;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

// @Component 
public class JavaBooks implements Books {

	public JavaBooks() {
		System.out.println("JavaBooks created!");
	}
	@Override
	public List<String> getBooks() {
		 List<String> books = new ArrayList<>();
		 books.add("Spring in Action");
		 books.add("Java Complete Reference");
		 return books;
	}
	

}
