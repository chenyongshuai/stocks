package com.stocks.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stocks.entity.StockDay;
import com.stocks.service.PlateListService;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月21日 下午4:24:18 
  * @version：   1.0.0
  * @describe:    
  */
@Controller
@RequestMapping("/plate")
public class PlateController {
	@Autowired
	private PlateListService pls;
	
	@RequestMapping("/getStockList/{plateBuid}")
	@ResponseBody
	public Map<String, Object> getListByPlate(@PathVariable(value="plateBuid")String plateBuid){
		return pls.getListByPlate(plateBuid);
	}
}
