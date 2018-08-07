package com.stocks.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stocks.entity.BaseUser;
import com.stocks.service.BaseUserService;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月20日 下午6:23:34 
  * @version：   1.0.0
  * @describe:    
  */

@Controller
@RequestMapping("/user")
public class BaseUserController {
	
	@Autowired
	private BaseUserService service;
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public boolean login(BaseUser user,HttpSession session){
		Boolean isExists = service.getByUser(user);
		if(isExists){
			session.setAttribute("user", user);
			return true;
		}
		return false;
	}
	
	@RequestMapping("/isExistsMobileNo/{username}")
	@ResponseBody
	public boolean isExistsMobileNo(@PathVariable(value="username")String userMobileNo){
		if(userMobileNo.length()!=11){
			return false;
		}
		return service.getByUserMobile(userMobileNo);
	}
	
	@RequestMapping("/isExistsNickName/{nickname}")
	@ResponseBody
	public boolean isExistsNickName(@PathVariable(value="nickname")String nickname){
		return service.getByNickName(nickname);
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public boolean reg(BaseUser user){
		boolean isExists = service.addUser(user);
		if(isExists){
			return true;
		}
		return false;
	}
	
	
}
