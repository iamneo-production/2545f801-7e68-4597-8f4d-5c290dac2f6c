package com.examly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.examly.dao.IUserModel;

@RestController
public class UserController {
	@Autowired
	IUserModel user;

	@GetMapping("/")
	public String arrayOfUser() {
		return "Welcome SpringBoot LMS";
	}

}
