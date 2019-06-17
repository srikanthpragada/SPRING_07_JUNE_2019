package web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jpa.Department;
import jpa.DeptRepo;

@Controller 
public class DeptController {
	
	@Autowired
	private DeptRepo depts;
	
	@RequestMapping("/dept")
	public String getDept(@RequestParam("id") int id, ModelMap model) {
		Optional<Department> dept = depts.findById(id);
		if (dept.isPresent())
			model.put("dept",dept.get());
		else
			model.put("message","Sorry! Department Id not found!");
		
		return "deptinfo";
	}

}
