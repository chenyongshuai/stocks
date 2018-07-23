package com.stocks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocks.service.StockService;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月19日 下午4:40:28 
  * @version：   1.0.0
  * @describe:    
  */
@RestController
@RequestMapping("/stock")
public class StockController {
	
	@Autowired
	private StockService service;
	
	
	@RequestMapping(value = "/getById/{buid}")
	public String getById(@PathVariable(value="buid")String buid){
		return service.getStockByBuid(buid).toString();
	}
}
