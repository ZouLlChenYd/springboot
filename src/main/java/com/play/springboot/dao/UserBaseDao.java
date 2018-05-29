package com.play.springboot.dao;

import org.springframework.stereotype.Repository;

import com.play.springboot.entity.UserBase;

@Repository
public class UserBaseDao {
	public UserBase findUser(String username,String password) {
		UserBase userBase=new UserBase();
		userBase.setUsername(username);
		userBase.setPassword(password);
		userBase.setDeleted("0");
		return userBase;
	}
}
