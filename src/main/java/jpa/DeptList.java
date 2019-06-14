package jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component 
public class DeptList implements CommandLineRunner {

	@Autowired
	private DeptRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		for (Department d : repo.findAll())
			System.out.println(d.getName());
		
	}

}
