package web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jpa.Department;
import jpa.DeptRepo;

@RestController
@RequestMapping("/rest/dept")
public class RestDeptController {

	@Autowired
	DeptRepo deptRepo;

	@GetMapping() // For Http GET request
	public Iterable<Department> getAllDept() {
		return deptRepo.findAll();
	}

	@GetMapping("/{id}") // For Http GET request with id
	public Department getOneDept(@PathVariable("id") int id) {
		Optional<Department> dept = deptRepo.findById(id);
		if (dept.isPresent())
			return dept.get();
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department Id Not Found");
	}

	@PostMapping() // For Http POST request
	public Department addDept(Department dept) {
		try {
			deptRepo.save(dept);
			return dept;
		} catch (Exception ex) {
			System.out.println(ex);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Data");
		}
	}

	@DeleteMapping("/{id}") // For Http DELETE request
	public void deleteDept(@PathVariable("id") int id) {
		Optional<Department> dept = deptRepo.findById(id);
		if (dept.isPresent()) {
			try {
				deptRepo.delete(dept.get());
			} catch (Exception ex) {
				System.out.println(ex);
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			throw new ResponseStatusException
			     (HttpStatus.NOT_FOUND, "Department Id Not Found!");
		}
	}

}
