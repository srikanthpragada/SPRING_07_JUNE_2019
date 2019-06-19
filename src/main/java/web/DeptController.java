package web;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
			model.addAttribute("dept", dept.get());
		else
			model.addAttribute("message", "Sorry! Department Id not found!");

		return "deptinfo";
	}

	@RequestMapping("/deptlist")
	public String getDeptList(ModelMap model) {
		model.addAttribute("depts", depts.findAll());
		return "deptlist";
	}

	@RequestMapping("/adddept")
	public String addDept(ModelMap model) {
		Department d = new Department();
		model.addAttribute("dept", d);
		return "add_dept";
	}

	@RequestMapping(value = "/adddept", method = RequestMethod.POST)
	public String addDept(@Valid Department d, Errors errors, ModelMap model) {

		try {
			if (errors.getErrorCount() > 0)
				throw new RuntimeException(errors.toString());

			if (depts.findById(d.getId()).isPresent())
				throw new RuntimeException("Dept Id exits");

			depts.save(d);
			return "redirect:/deptlist";
		} catch (Exception ex) {
			model.addAttribute("dept", d);
			model.addAttribute("message", ex.getMessage());
			return "add_dept";
		}
	}
	
	
	@RequestMapping("/editdept/{id}")
	public String editDept(@PathVariable("id") int id, ModelMap model) {
		Optional<Department> dept = depts.findById(id);
		if (dept.isPresent())
			model.addAttribute("dept", dept.get());
		else
			model.addAttribute("error","Department Id Not Found!");
		
		return "edit_dept";
	}
	
	@RequestMapping(value = "/countdept")
	@ResponseBody
	public int getDeptCount() {
		return  depts.getCount();
	}
	
	@RequestMapping(value = "/editdept/{id}", method = RequestMethod.POST)
	public String updateDept(@PathVariable("id") int id, 
			                 Department d, ModelMap model) {
		try {
			depts.save(d);
			return "redirect:/deptlist";
		} catch (Exception ex) {
			model.addAttribute("dept", d);
			model.addAttribute("error", ex.getMessage());
			return "edit_dept";
		}
	}


}
