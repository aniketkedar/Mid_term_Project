package com.axis.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.User;
import com.example.demo.services.AdminService;
import com.example.demo.services.PaySlipServices;
import com.example.demo.services.UserService;

@Controller
public class EmpController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private PaySlipServices payService;
	@ResponseBody
	@RequestMapping("/home")
	public String hello() {
		return "welcome";
	}
	@RequestMapping("/welcome")
	public String welcome(HttpServletRequest req)
	{
		req.setAttribute("mode", "MODE_HOME");
		return "welcomeemployee";
	}
	
	@RequestMapping("/register")
	public String registration(HttpServletRequest req) {
		return "register";
	}
	
	@RequestMapping("/save-user")
	public String saveUser(@ModelAttribute User user,BindingResult bindingresult, HttpServletRequest request) {
		userService.saveMyUser(user);
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "MODE_HOME");
		return "allusers";	
	}
}	
	
	
