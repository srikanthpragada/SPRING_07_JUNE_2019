package web;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	@ResponseBody
	public String hello(@RequestParam(name = "name", required=false)
	                    String name) {
       if(name == null)
    	    name = "Guest";
       
       return "<h1>Hello " + name + "</h1>";
	}
	
	@RequestMapping("/greet")
	public String greet(@RequestParam(name="user", required=false) String user,
			            ModelMap model) {
		 if (user == null)
			  user = "Guest";
		 
		 model.put("user",user);
		 model.put("today", LocalDate.now().toString());
         return "greet";       
	}
}
