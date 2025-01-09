package com.cdac.training.usersoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.training.usersoft.model.User;
import com.cdac.training.usersoft.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



/**
*Author :Gautam Sharma
*Date   :31-Dec-2024
*Time   :11:58:27 am
*/

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@GetMapping("/")
	public String showIndexPage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegisterPage(Model m) {
		User user =new User();
		m.addAttribute("user", user);
		return "register";
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute User user,Model model) {
		userService.registerUser(user);
		model.addAttribute("message","registraction successful !please login");
		return "login";
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam String email,@RequestParam String password,HttpSession session,Model model) {
		var user=userService.loginUser(email, password);
		if(user.isPresent()) {
			
			session.setAttribute("loggedUser", user.get());
			return "redirect:/home";
		}
		else {
			
			model.addAttribute("error", "invalid email/password");
			return "login";
		}	
	}
	
	@GetMapping("/home")
	public String showHomePage(HttpSession session,Model model) {
	var user=session.getAttribute("loggedUser");
	if(user==null) {
		return "redirect:/login";
	}
	model.addAttribute("user", user);
	return "home";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
}
