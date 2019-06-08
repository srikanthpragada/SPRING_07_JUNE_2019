package com.st.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component 
public class TestBook implements CommandLineRunner {
	@Autowired
    Catalog catalog; 
	
	
	@Override
	public void run(String... args) throws Exception {
		catalog.print(); 
	}

	  

}
