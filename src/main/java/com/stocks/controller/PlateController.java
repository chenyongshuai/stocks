package com.stocks.controller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stocks.service.PlateListService;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月21日 下午4:24:18 
  * @version：   1.0.0
  * @describe:    
  */
@Controller
@RequestMapping("/list")
public class PlateController {
	@Autowired
	private PlateListService pls;
	
	@RequestMapping("/getStockList/{plateBuid}")
	@ResponseBody
	public Map<String, Object> getListByPlate(@PathVariable(value="plateBuid")String plateBuid){
		//System.out.println(pls.getListByPlate(plateBuid));
		return pls.getListByPlate(plateBuid);
	}
	
	@RequestMapping("/addStockList/{plateBuid}/{buid}")
	@ResponseBody
	public boolean addStockList(@PathVariable(value="plateBuid")String plateBuid, @PathVariable(value="buid")String buid){
		boolean isAdd = pls.addStockList(plateBuid,buid);
		return isAdd;
	}
	
	@RequestMapping("/delStockList")
	@ResponseBody
	public boolean addStockList(String plateBuid, String[] buidList){
		boolean isDel = pls.delStockList(plateBuid,buidList);
		return isDel;
	}
	
}
