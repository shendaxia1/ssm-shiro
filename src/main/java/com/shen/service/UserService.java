package com.shen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shen.mapper.User;

@Service
public class UserService {
	@Autowired
	private User user;
	public List<User> allService(){
		return user.all();
	}

}
