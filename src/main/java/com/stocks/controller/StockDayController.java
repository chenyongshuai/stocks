package com.stocks.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stocks.entity.StockDay;
import com.stocks.service.StockDayService;

@Controller
@RequestMapping("/day")
public class StockDayController {
	
	@Autowired
	private StockDayService sds;
	
	@RequestMapping("/getByBuid/{buid}")
	public @ResponseBody List<StockDay> getByBuid(@PathVariable(value="buid") String buid){
		
		//String realPath = request.getSession().getServletContext().getRealPath("/");//获取web项目的路径
		//boolean isAdd = sdds.addStockByBuidAndPath(realPath,buid);
		List<StockDay> byBuid = sds.getByBuid(buid);
		
		return byBuid;
	}
}
