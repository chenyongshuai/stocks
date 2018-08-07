package com.stocks.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stocks.service.StockDayService;

@Controller
@RequestMapping("/day")
public class StockDayController {
	
	@Autowired
	private StockDayService sdds;
	
	@RequestMapping("/getByBuid/{buid}")
	public @ResponseBody boolean getByBuid(HttpServletRequest request,@PathVariable(value="buid") String buid){
		
		String realPath = request.getSession().getServletContext().getRealPath("/");//获取web项目的路径
		boolean isAdd = sdds.addStockByBuidAndPath(realPath,buid);
		
		return isAdd;
	}
}
