package com.vechicle.breakdown.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vechicle.breakdown.model.Breakdown;
import com.vechicle.breakdown.model.Users;
import com.vechicle.breakdown.service.BreakdownService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BreakdownController {

	
	 @Autowired
	    private BreakdownService breakdownService;

	    @GetMapping("/dashboard")
	    public String userDashboard(Model model, HttpSession session) {
	        Users user = (Users) session.getAttribute("user");
	        if (user == null) return "redirect:/login";

	        model.addAttribute("breakdowns", breakdownService.getUserBreakdowns(user.getId()));
	        return "dashboard";
	    }

	    @PostMapping("/submit-breakdown")
	    public String submitBreakdown(@ModelAttribute Breakdown breakdown, HttpSession session) {
	        Users user = (Users) session.getAttribute("user");
	        if (user == null) return "redirect:/login";

	        breakdown.setUser(user);
	        breakdownService.addBreakdown(breakdown);
	        return "redirect:/dashboard";
	    }
}
