package com.play.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.play.springboot.dao.UserBaseDao;
import com.play.springboot.entity.UserBase;
import com.play.springboot.mapper.UserBaseMapper;

@RestController
public class UserController {
	
	@Autowired
	private UserBaseDao userBaseDao;
	@Autowired
	private UserBaseMapper userBaseMapper;
//	@Autowired
//	private RedisService redisService;
	
	@RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
	
	@RequestMapping("findUserBase")
	@ResponseBody
	public UserBase findUser(String username,String password) {
		UserBase user = userBaseDao.findUser(username, password);
//		redisService.set("user", user);
		return user;
	}
	
	@RequestMapping("insertUserBase")
	@ResponseBody
	public String insertUserBase(String username,String password) {
		UserBase user=new UserBase();
		user.setUsername(username);
		user.setPassword(password);
		user.setDeleted("0");
		userBaseMapper.insert(user);
		return "添加成功";
	}
	
	
	@RequestMapping("updateUserBase")
	@ResponseBody
	public String updateUserBase(String username,String password) {
		UserBase user=new UserBase();
		user.setUsername(username);
		user.setPassword(password);
		userBaseMapper.update(user);
		return "添加成功";
	}
	
	@RequestMapping("deleteUserBase")
	@ResponseBody
	public String deleteUserBase(String username) {
		userBaseMapper.delete(username);
		return "删除成功";
	}
	
	@RequestMapping("selectUserBase")
	@ResponseBody
	public List<UserBase> selectUserBase() {
		List<UserBase> all = userBaseMapper.getAll();
		return all;
	}
	
	
}
