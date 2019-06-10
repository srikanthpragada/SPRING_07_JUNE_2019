package com.st.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("python")  // python is name of the bean
@Scope(scopeName = "prototype")
public class PythonBooks implements Books {
	public PythonBooks() {
		System.out.println("PythonBooks created!");
	}
	@Override
	public List<String> getBooks() {
		 List<String> books = new ArrayList<>();
		 books.add("Python Tricks");
		 books.add("Data Science with Python");
		 return books;
	}

}
