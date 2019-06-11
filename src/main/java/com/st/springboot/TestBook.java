package com.st.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
public class TestBook implements CommandLineRunner {
	@Autowired(required = false)
    Catalog catalog; 
	
	public static void main(String... args)
	{
		SpringApplication.run(TestBook.class, args);
	}
	
	public TestBook() {
		System.out.println("TestBook instantiated");
	}
	@Override
	public void run(String... args) throws Exception {
		catalog.print(); 
//		catalog.printUpper();
		catalog.process(10);
	}

	  

}
