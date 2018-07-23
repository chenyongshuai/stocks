package com.stocks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocks.dao.StockDayDao;
import com.stocks.entity.StockDay;
import com.stocks.service.StockDayService;


/** @author:  v_chenyongshuai@:
  * @date:  2018��7��16�� ����9:57:32 
  * @version��   1.0.0
  * @describe:    
  */
@Service
public class StockDayServiceImpl implements StockDayService{

	@Autowired
	private StockDayDao dao;
	

	public int addStockDay(StockDay sdd) {
		return dao.addStockDay(sdd);
	}


	public List<StockDay> getByBuid(String buid) {
		return dao.getByBuid(buid);
	}

}
