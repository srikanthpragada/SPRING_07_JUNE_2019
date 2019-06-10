package com.st.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication 
public class TestBook implements CommandLineRunner {
	@Autowired
    Catalog catalog; 
	
	public TestBook() {
		System.out.println("TestBook instantiated");
	}
	@Override
	public void run(String... args) throws Exception {
		catalog.print(); 
	}

	  

}
