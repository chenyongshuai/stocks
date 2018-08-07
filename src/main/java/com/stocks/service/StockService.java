package com.stocks.service;

import java.util.List;


import com.stocks.entity.Stock;

/** @author:  v_chenyongshuai@:
  * @date:  2018��7��15�� ����7:30:14 
  * @version��   1.0.0
  * @describe:    
  */
public interface StockService {
	/**
	 * 
	 * @param stockNo
	 * @return Stock
	 */
	Stock getStockByNo(String stockNo);
	/**
	 * 
	 * @param buid
	 * @return Stock
	 */
	Stock getStockByBuid(String buid);
	/**
	 * 
	 * @param stock
	 * @return int
	 */
	int addStock(Stock stock);
	/**
	 * 
	 * @return List<Stock>
	 */
	List<Stock> getAll();
}
