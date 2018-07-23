package com.stocks.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String login(BaseUser user,HttpSession session){
		Boolean isExists = service.getByUser(user);
		if(isExists){
			session.setAttribute("user", user);
			return "true";
		}
		return "false";
	}
}
