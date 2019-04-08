package com.stocks.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stocks.dao.StockDao;
import com.stocks.dao.StockDayDao;
import com.stocks.dao.StockWeekDao;
import com.stocks.entity.SohuStock;
import com.stocks.entity.Stock;
import com.stocks.entity.StockDay;
import com.stocks.entity.StockWeek;
import com.stocks.service.StockDayService;
import com.stocks.util.HttpUtils;


@Service
@Configuration
public class StockDayServiceImpl implements StockDayService{

	@Autowired
	private StockDayDao dao;
	
	@Autowired
	private StockWeekDao swd;

	@Autowired
	private StockDao sd;

	public int addStockDay(StockDay sdd) {
		return dao.addStockDay(sdd);
	}


	public List<StockDay> getByBuid(String buid) {
		return dao.getByBuid(buid);
	}

	/*
	@PostConstruct
	public void initMarket(){
		List<Stock> all = sd.getAll();
		String realPath = "E:\\chenys\\stocks\\src\\main\\webapp\\";
		for (Stock st : all) {
			String buid = st.getBuid();
			StockDay lastByBuid = dao.getLastByBuid(buid);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String detailDay = null;
			if(lastByBuid!=null){
				detailDay = lastByBuid.getDetailDay();
			}
			String startDate = null;
			if(detailDay==null){
				startDate = "19900101";
			}else{
				startDate = detailDay;
			}
			//get Stock
			Stock stock = sd.getStockByBuid(buid);
			//add Stockday
			String doGet = HttpUtils.doGet(SohuStock.sohuURL.replace("(1)", stock.getStockNo()).replace("(2)", startDate).replace("(3)", sdf.format(new Date())));
			JSONObject jsonObject = JSON.parseObject(doGet.substring(doGet.indexOf("(")+2, doGet.lastIndexOf(")")-1));
			int status = (Integer) jsonObject.get("status");
			if(status==2){
				continue;
			}
			String[] jsonObjectArr = jsonObject.get("hq").toString().split("\\],\\[");
			for (String obj : jsonObjectArr) {
				String replace = obj.replace("\"", "").replace("[[", "").replace("]]", "").replace("%", "");
				String[] columns = replace.split(",");
				StockDay buidAndDay = dao.getByBuidAndDay(buid, columns[0]);
				if(buidAndDay == null){
					String c9 = "";
					if("-".equals(columns[9])){
						c9 = "0";
					}else{
						c9 = columns[9];
					}
					StockDay sdd = new StockDay(buid, columns[0], Double.parseDouble(columns[1]), Double.parseDouble(columns[2]), columns[3], Double.parseDouble(columns[4]), Double.parseDouble(columns[5]), Double.parseDouble(columns[6]), Double.parseDouble(columns[7]), Double.parseDouble(columns[8]), Double.parseDouble(c9),0,0,0, null, "chenys", null, "chenys");
					int addCount = dao.addStockDay(sdd);
					System.out.println("插入分时成交数据---day---代码："+stock.getStockNo()+",名称："+stock.getStockCnName()+",日期："+sdd.getDetailDay()+",条数："+addCount);
				}
			}
			//get Stockday
			List<StockDay> stockDay = dao.getByBuid(buid);
			//create json file
			ArrayList<Object[]>list = new ArrayList<Object[]>();
			for (StockDay s : stockDay) {
				Object[]arr = new Object[6];
				arr[0] = s.getDetailDay();
				arr[1] = s.getOpenPrice();
				arr[2] = s.getClosePrice();
				arr[3] = s.getLowPrice();
				arr[4] = s.getTopPrice();
				arr[5] = s.getDealCount();
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
				}else{
					file.delete();
					file.createNewFile();
				}
				IOUtils.write(jsonString, new FileOutputStream(file));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		for (Stock st : all) {
			String buid = st.getBuid();
			System.out.println(st);
			StockWeek lastByBuid = swd.getLastByBuid(buid);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String detailDay = null;
			if(lastByBuid!=null){
				detailDay = lastByBuid.getDetailDay();
			}
			String startDate = null;
			if(detailDay==null){
				startDate = "19900101";
			}else{
				startDate = detailDay;
			}
			//get Stock
			Stock stock = sd.getStockByBuid(buid);
			System.out.println(stock);
			//add StockWeek
			String doGet = HttpUtils.doGet(SohuStock.weekURL.replace("(1)", stock.getStockNo()).replace("(2)", startDate).replace("(3)", sdf.format(new Date())));
			System.out.println(doGet);
			JSONObject jsonObject = JSON.parseObject(doGet.substring(doGet.indexOf("(")+2, doGet.lastIndexOf(")")-1));
			int status = (Integer) jsonObject.get("status");
			if(status==2){
				continue;
			}
			String[] jsonObjectArr = jsonObject.get("hq").toString().split("\\],\\[");
			for (String obj : jsonObjectArr) {
				String replace = obj.replace("\"", "").replace("[[", "").replace("]]", "").replace("%", "");
				String[] columns = replace.split(",");
				StockWeek buidAndDay = swd.getByBuidAndDay(buid, columns[0]);
				if(buidAndDay == null){
					StockWeek sdd = new StockWeek(buid, columns[0], Double.parseDouble(columns[1]), Double.parseDouble(columns[2]), columns[3], Double.parseDouble(columns[4]), Double.parseDouble(columns[5]), Double.parseDouble(columns[6]), Double.parseDouble(columns[7]), Double.parseDouble(columns[8]), 0, null, "chenys", null, "chenys");
					int addCount = swd.addStockWeek(sdd);
					System.out.println("插入分时成交数据---week---代码："+stock.getStockNo()+",名称："+stock.getStockCnName()+",日期："+sdd.getDetailDay()+",条数："+addCount);
				}
			}
			//get Stockday
			List<StockWeek> stockWeek = swd.getByBuid(buid);
			//create json file
			ArrayList<Object[]>list = new ArrayList<Object[]>();
			for (StockWeek s : stockWeek) {
				Object[]arr = new Object[6];
				arr[0] = s.getDetailDay();
				arr[1] = s.getOpenPrice();
				arr[2] = s.getClosePrice();
				arr[3] = s.getLowPrice();
				arr[4] = s.getTopPrice();
				arr[5] = s.getDealCount();
				list.add(arr);
			}
			String jsonString = JSON.toJSONString(list);
			try {
				System.out.println(realPath);
				File file = new File(realPath+"data\\week\\"+buid+".json");
				if(!file.exists()){
					File parentFile = file.getParentFile();
					parentFile.mkdirs();
					file.createNewFile();
				}else{
					file.delete();
					file.createNewFile();
				}
				IOUtils.write(jsonString, new FileOutputStream(file));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	*/

	@Override
	public boolean addStockByBuidAndPath(String realPath, String buid) {
		/*//get last stockday
		StockDay lastByBuid = dao.getLastByBuid(buid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		//System.out.println(lastByBuid);
		String detailDay = null;
		if(lastByBuid!=null){
			detailDay = lastByBuid.getDetailDay();
		}
		String startDate = null;
		if(detailDay==null){
			startDate = "19900101";
		}else{
			startDate = detailDay;
		}
		//get Stock
		Stock stock = sd.getStockByBuid(buid);
		//add Stockday
		String doGet = HttpUtils.doGet(SohuStock.sohuURL.replace("(1)", stock.getStockNo()).replace("(2)", startDate).replace("(3)", sdf.format(new Date())));
		JSONObject jsonObject = JSON.parseObject(doGet.substring(doGet.indexOf("(")+2, doGet.lastIndexOf(")")-1));
		String[] jsonObjectArr = jsonObject.get("hq").toString().split("\\],\\[");
		for (String obj : jsonObjectArr) {
			String replace = obj.replace("\"", "").replace("[[", "").replace("]]", "").replace("%", "");
			String[] columns = replace.split(",");
			StockDay buidAndDay = dao.getByBuidAndDay(buid, columns[0]);
			if(buidAndDay == null){
				StockDay sdd = new StockDay(buid, columns[0], columns[1], columns[2], columns[3], columns[4],columns[5], columns[6], columns[7], columns[8], columns[9], null ,null ,null ,null ,null ,null , null, "chenys", null, "chenys");
				int addCount = dao.addStockDay(sdd);
				System.out.println("插入分时成交数据------代码："+stock.getStockNo()+",名称："+stock.getStockCnName()+",日期："+sdd.getDetailDay()+",条数："+addCount);
			}
		}*/
		//get Stockday
		List<StockDay> stockDay = dao.getByBuid(buid);
		//create json file
		ArrayList<Object[]>list = new ArrayList<Object[]>();
		for (StockDay s : stockDay) {
			Object[]arr = new Object[9];
			arr[0] = s.getDetailDay();
			arr[1] = s.getOpenPrice();
			arr[2] = s.getClosePrice();
			arr[3] = s.getLowPrice();
			arr[4] = s.getTopPrice();
			arr[5] = s.getDealCount();
			arr[6] = s.getDif();
			arr[7] = s.getDea();
			arr[8] = s.getMacd();
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
			}else{
				file.delete();
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
