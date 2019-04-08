package com.stocks.test.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stocks.SpringBootApplication;
import com.stocks.dao.StockDao;
import com.stocks.dao.StockDayDao;
import com.stocks.dao.StockWeekDao;
import com.stocks.entity.SohuStock;
import com.stocks.entity.Stock;
import com.stocks.entity.StockDay;
import com.stocks.entity.StockWeek;
import com.stocks.util.HttpUtils;
import com.stocks.vo.StockDayVO;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月21日 下午10:30:17 
  * @version：   1.0.0
  * @describe:    
  */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SpringBootApplication.class)
public class StockDayDaoTest {
	@Autowired
	private StockDayDao dao;

	@Autowired
	private StockWeekDao swd;
	
	@Autowired
	private StockDao sd;
	
	@Test
	public void test(){
		StockDayVO stockDayVO = dao.getByBuidLast("1014fd95-194c-4382-82c4-5d3dbb38b711");
		System.out.println(stockDayVO);
	}
	
	@Test
	public void testWeekAdd(){
		List<Stock> all = sd.getAll();
		String realPath = "E:\\chenys\\stocks\\src\\main\\webapp\\";
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
					StockDay sdd = new StockDay();					
					//int addCount = swd.addStockWeek(sdd);
					//System.out.println("插入分时成交数据---week---代码："+stock.getStockNo()+",名称："+stock.getStockCnName()+",日期："+sdd.getDetailDay()+",条数："+addCount);
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
	
}
