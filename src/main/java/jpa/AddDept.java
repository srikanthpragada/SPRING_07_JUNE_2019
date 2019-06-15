package jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component 
public class AddDept {

	@Autowired
	DeptRepo  repo;
	
	public void add(int id, String name) {
		Department d = new Department();
		d.setId(id);
		d.setName(name);
		repo.save(d);
		System.out.println("Department has been added successfully!");
	}

}
