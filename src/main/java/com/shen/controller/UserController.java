package com.shen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shen.mapper.User;
import com.shen.service.UserService;

@Controller
@RequestMapping("User")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("all")
	public String allController(Model model) {
		List<User> list = new ArrayList<User>();
		list = userService.allService();
		model.addAttribute("list", list);
		return "login";
	}

}
