package jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestJPA implements CommandLineRunner {

	@Autowired
	DeptList dept;
	
	@Autowired
	AddDept addDept;
	
	public static void main(String[] args) {
		 SpringApplication.run(TestJPA.class, args);
	}
	
	public void run(String ... args) {
		 // addDept.add(300, "Sports");
		 // dept.list();
		 // dept.listById(200);
	}

}
