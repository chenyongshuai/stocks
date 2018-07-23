package com.stocks.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stocks.entity.SohuStock;
import com.stocks.entity.Stock;
import com.stocks.entity.StockDay;
import com.stocks.service.StockDayService;
import com.stocks.service.StockSecService;
import com.stocks.service.StockService;
import com.stocks.util.HttpUtils;


/** @author:  v_chenyongshuai@:
  * @date:  2018��7��15�� ����6:40:36 
  * @version��   1.0.0
  * @describe: 
  */
@Controller
@RequestMapping("/sina")
public class StockMarketController {
	
	@Autowired
	private StockSecService sdss;
	
	@Autowired
	private StockDayService sdds;
	
	@Autowired
	private StockService ss;
	
	@RequestMapping("/getPrice")
	public @ResponseBody String getPrice(String buid){
		//1014fd95-194c-4382-82c4-5d3dbb38b711
		Stock stock = ss.getStockByBuid(buid);
		String doGet = HttpUtils.doGet(SohuStock.sohuURL.replace("(1)", stock.getStockNo()).replace("(2)", "20100101").replace("(3)", new SimpleDateFormat("yyyyMMdd").format(new Date())));
		JSONObject jsonObject = JSON.parseObject(doGet.substring(doGet.indexOf("(")+2, doGet.lastIndexOf(")")-1));
		String[] jsonObjectArr = jsonObject.get("hq").toString().split("\\],\\[");
		for (String obj : jsonObjectArr) {
			String replace = obj.replace("\"", "").replace("[[", "").replace("]]", "").replace("%", "");
			String[] columns = replace.split(",");
			StockDay sdd = new StockDay(buid, columns[0], Double.parseDouble(columns[1]), Double.parseDouble(columns[2]), columns[3], Double.parseDouble(columns[4]), Double.parseDouble(columns[5]), Double.parseDouble(columns[6]), Double.parseDouble(columns[7]), Double.parseDouble(columns[8]), Double.parseDouble(columns[9]), null, "chenys", null, "chenys");
			int addCount = sdds.addStockDay(sdd);
			System.out.println("插入分时成交数据------代码："+stock.getStockNo()+",名称："+stock.getStockCnName()+",日期："+sdd.getDetailDay()+",条数："+addCount);
		}
		return "1";
	}
}
