package com.vechicle.breakdown.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vechicle.breakdown.model.Users;
import com.vechicle.breakdown.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/users") 
public class AuthController {
	
	@Autowired
	UserService userService;
	
	
	
	 @GetMapping("/register")
	    public String showRegisterPage() {
	        return "register";
	    } 

	 @PostMapping("/register")
	    public ModelAndView registerUser(@RequestParam("name") String name,
	                                     @RequestParam("email") String email,
	                                     @RequestParam("phone") String phone,
	                                     @RequestParam("password") String password,
	                                     @RequestParam("confirmPassword") String confirmPassword) {
		 
	        ModelAndView modelAndView = new ModelAndView();

	        if (!password.equals(confirmPassword)) {
	            modelAndView.setViewName("register");
	            modelAndView.addObject("errorMessage", "Passwords do not match.");
	            return modelAndView;
	        }
	        Users user = new Users();
	        user.setName(name);
	        user.setEmail(email);
	        user.setPhone(phone);
	        user.setPassword(password);

	        userService.registerUser(user);
	        System.out.println("User registered successfully!");

	        // Pass success message & redirect to login page
	        modelAndView.setViewName("login");  // This will trigger login.jsp
	        modelAndView.addObject("successMessage", "Registration successful! Please log in.");
	        return modelAndView;
	    }
	    @GetMapping("/login")
	    public String showLoginPage() {
	        return "login";
	    }
	    @PostMapping("/login")
	    public String loginUser(@RequestParam String email, @RequestParam String password, HttpSession session) {
	        Users user = userService.loginUser(email, password);
	        if (user != null) {
	            session.setAttribute("user", user);
	            return "redirect:/dashboard";
	        }
	        return "login";
	    }
	    @GetMapping("/logout")
	    public String logoutUser(HttpSession session) {
	        session.invalidate();
	        return "redirect:/login";
	    }
}
