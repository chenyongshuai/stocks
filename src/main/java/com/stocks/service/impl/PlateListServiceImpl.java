package com.stocks.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocks.dao.PlateListDao;
import com.stocks.dao.StockDayDao;
import com.stocks.entity.PlateList;
import com.stocks.entity.StockDay;
import com.stocks.service.PlateListService;
import com.stocks.vo.StockDayVO;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月21日 下午4:29:08 
  * @version：   1.0.0
  * @describe:    
  */
@Service
public class PlateListServiceImpl implements PlateListService{
	@Autowired
	private PlateListDao pld;
	
	@Autowired
	private StockDayDao sdd;
	
	@Override
	public Map<String,Object> getListByPlate(String plateBuid) {
		Map<String,Object>map = new HashMap<String, Object>();
		List<PlateList> plateList = pld.getPlateList(plateBuid);
		List<StockDayVO> stockList = new ArrayList<StockDayVO>();
		for (PlateList list : plateList) {
			String stockBuid = list.getStockBuid();
			double addPrice = list.getAddPrice();
			StockDayVO byBuidNow = sdd.getByBuidLast(stockBuid);
			double closePrice = byBuidNow.getClosePrice();
			//System.out.println(addPrice+" --> "+closePrice);
			double percent = (double) ( Math.round((closePrice-addPrice)/addPrice*10000)/100);
			//System.out.println(percent);
			String percentStr = percent +"%";
			byBuidNow.setAddEarn(percentStr);
			stockList.add(byBuidNow);
		}
		map.put("data", stockList);
		map.put("count", pld.getPlateListCount(plateBuid));
		map.put("code", "0");
		System.out.println(map);
		return map;
	}

	@Override
	public boolean addStockList(String plateBuid, String buid) {
		PlateList byPlateAndStock = pld.getByPlateAndStock(plateBuid, buid);
		if(byPlateAndStock==null){
			StockDay lastByBuid = sdd.getLastByBuid(buid);
			int addStockList = pld.addStockList(plateBuid, buid, lastByBuid.getClosePrice());
			if(addStockList ==1){
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean delStockList(String plateBuid,  String[] buidList) {
		int delByPlateAndStock = pld.delByPlateAndStock(buidList,plateBuid);
		if(delByPlateAndStock>=1){
			return true;
		}
		return false;
	}

}
