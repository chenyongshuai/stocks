package com.stocks.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stocks.dao.StockDao;
import com.stocks.dao.StockDayDao;
import com.stocks.entity.SohuStock;
import com.stocks.entity.Stock;
import com.stocks.entity.StockDay;
import com.stocks.service.StockDayService;
import com.stocks.util.HttpUtils;


@Service
public class StockDayServiceImpl implements StockDayService{

	@Autowired
	private StockDayDao dao;

	@Autowired
	private StockDao sd;

	public int addStockDay(StockDay sdd) {
		return dao.addStockDay(sdd);
	}


	public List<StockDay> getByBuid(String buid) {
		return dao.getByBuid(buid);
	}


	@Override
	public boolean addStockByBuidAndPath(String realPath, String buid) {
		//get Stock
		Stock stock = sd.getStockByBuid(buid);
		//add Stockday
		String doGet = HttpUtils.doGet(SohuStock.sohuURL.replace("(1)", stock.getStockNo()).replace("(2)", "19900101").replace("(3)", new SimpleDateFormat("yyyyMMdd").format(new Date())));
		JSONObject jsonObject = JSON.parseObject(doGet.substring(doGet.indexOf("(")+2, doGet.lastIndexOf(")")-1));
		String[] jsonObjectArr = jsonObject.get("hq").toString().split("\\],\\[");
		for (String obj : jsonObjectArr) {
			String replace = obj.replace("\"", "").replace("[[", "").replace("]]", "").replace("%", "");
			String[] columns = replace.split(",");
			StockDay buidAndDay = dao.getByBuidAndDay(buid, columns[0]);
			if(buidAndDay == null){
				StockDay sdd = new StockDay(buid, columns[0], Double.parseDouble(columns[1]), Double.parseDouble(columns[2]), columns[3], Double.parseDouble(columns[4]), Double.parseDouble(columns[5]), Double.parseDouble(columns[6]), Double.parseDouble(columns[7]), Double.parseDouble(columns[8]), Double.parseDouble(columns[9]), null, "chenys", null, "chenys");
				int addCount = dao.addStockDay(sdd);
				System.out.println("插入分时成交数据------代码："+stock.getStockNo()+",名称："+stock.getStockCnName()+",日期："+sdd.getDetailDay()+",条数："+addCount);
			}
		}
		//get Stockday
		List<StockDay> stockDay = dao.getByBuid(buid);
		//create json file
		ArrayList<String[]>list = new ArrayList<String[]>();
		for (StockDay s : stockDay) {
			String[]arr = new String[6];
			arr[0] = s.getDetailDay();
			arr[1] = s.getOpenPrice().toString();
			arr[2] = s.getClosePrice().toString();
			arr[3] = s.getLowPrice().toString();
			arr[4] = s.getTopPrice().toString();
			arr[5] = s.getDealCount().toString();
			list.add(arr);
		}
		String jsonString = JSON.toJSONString(list);
		try {
			System.out.println(realPath);
			File file = new File(realPath+"data\\"+buid+".json");
			if(!file.exists()){
				File parentFile = file.getParentFile();
				parentFile.mkdirs();
				file.createNewFile();
			}
			IOUtils.write(jsonString, new FileOutputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
