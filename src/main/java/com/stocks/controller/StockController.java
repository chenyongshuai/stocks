package com.stocks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stocks.entity.Stock;
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
	private StockService ss;
	
	
	@RequestMapping(value = "/getById/{buid}")
	public String getById(@PathVariable(value="buid")String buid){
		return ss.getStockByBuid(buid).toString();
	}
	
	@RequestMapping("/getAll")
	@ResponseBody
	public List<Stock> getAll(){
		return ss.getAll();
	}
}
