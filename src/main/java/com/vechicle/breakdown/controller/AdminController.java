package com.vechicle.breakdown.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vechicle.breakdown.exception.BreakdownNotFoundException;
import com.vechicle.breakdown.model.Breakdown;
import com.vechicle.breakdown.repository.BreakdownRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

	
	@Autowired
    private BreakdownRepository breakdownRepository;

    // Admin Dashboard - View All Breakdown Requests
    @GetMapping
    public String adminDashboard(Model model) {
        model.addAttribute("breakdowns", breakdownRepository.findAll());
        return "admin";  // This maps to admin.jsp
    }

    // Update Breakdown Status
    @PostMapping("/update-status/{id}")
    public String updateStatus(@PathVariable Long id, @RequestParam String status) {
        Breakdown breakdown = breakdownRepository.findById(id)
                .orElseThrow(() -> new BreakdownNotFoundException("Breakdown request not found"));
        
        breakdown.setStatus(status);
        breakdownRepository.save(breakdown);

        return "redirect:/admin";
    }
}
