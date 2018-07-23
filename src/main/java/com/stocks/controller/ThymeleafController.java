package com.stocks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月19日 下午7:42:53 
  * @version：   1.0.0
  * @describe:    
  */

@Controller
public class ThymeleafController {
	
	@RequestMapping("index")
	public String indexHtml(){
		return "index";
	}
	
	@RequestMapping("stockday")
	public String day(){
		return "stockday";
	}
	
	@RequestMapping("login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("reg")
	public String reg(){
		return "reg";
	}
	
	@RequestMapping("personal")
	public String personal(){
		return "personal";
	}
}
