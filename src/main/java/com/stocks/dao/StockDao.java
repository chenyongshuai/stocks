package com.stocks.dao;


import com.stocks.entity.Stock;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月19日 下午4:30:41 
  * @version：   1.0.0
  * @describe:    
  */
public interface StockDao {
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
}
