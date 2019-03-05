package com.infy.registration.contoller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infy.registration.model.User;
import com.infy.registration.repository.UserRepository;

@Controller
@RequestMapping("/registration")
public class AppController 
{
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(Model model)
	{
		model.addAttribute("user", new User());
		return "Login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute User user, Model model)
	{
		List<User> users = new ArrayList<>();
		users.add(user);
		model.addAttribute("users", users);
		return "LoginDetails";
	}
	
	@RequestMapping(value = "/submitData", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String submitForm(User user, Model model)
	{	
		int regNumber = userRepository.saveUser(user);
		model.addAttribute("regNumber", regNumber);
		return "SuccessPage";
	}
}
