package com.stocks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocks.dao.StockDao;
import com.stocks.entity.Stock;
import com.stocks.service.StockService;



/** @author:  v_chenyongshuai@:
  * @date:  2018��7��15�� ����7:31:43 
  * @version��   1.0.0
  * @describe:    
  */
@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockDao dao;
	public Stock getStockByNo(String stockNo) {
		return dao.getStockByNo(stockNo);
	}
	
	
	public Stock getStockByBuid(String buid) {
		return dao.getStockByBuid(buid);
	}


	public int addStock(Stock stock) {
		return dao.addStock(stock);
	}


	@Override
	public List<Stock> getAll() {
		return dao.getAll();
	}

}
