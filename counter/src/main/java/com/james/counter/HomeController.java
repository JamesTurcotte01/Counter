package com.james.counter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;


@Controller
public class HomeController {
	 @RequestMapping("/")
	    public String home(HttpSession session){
		 Integer count = (Integer) session.getAttribute("count");
		 @SuppressWarnings("deprecation")
		Integer counter = new Integer(count.intValue() +1);
		 session.setAttribute("count", counter);
			return "index.jsp";
	    }
    @RequestMapping("/counter")
    public String counter(Model model, HttpSession session){
        @SuppressWarnings("unused")
		Integer count = (Integer) session.getAttribute("count");
        model.addAttribute("count");
		return "counter.jsp";
    }
}