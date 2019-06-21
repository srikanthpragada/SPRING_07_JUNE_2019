package web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
public class ShowController {
	@RequestMapping("/show")
	@ResponseBody
	public String showName(HttpSession s) {
			return (String) s.getAttribute("name");
						
	}
}
