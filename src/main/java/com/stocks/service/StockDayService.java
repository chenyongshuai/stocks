package com.stocks.service;

import java.util.List;

import com.stocks.entity.StockDay;




/** @author:  v_chenyongshuai@:
  * @date:  2018��7��16�� ����9:55:48 
  * @version��   1.0.0
  * @describe:    
  */
public interface StockDayService {
	/**
	 * 
	 * @param sdd
	 * @return int
	 */
	int addStockDay(StockDay sdd);
	
	/**
	 * 
	 * @param buid 
	 * @return StockDetailDay
	 */
	List<StockDay> getByBuid(String buid);

	boolean addStockByBuidAndPath(String realPath, String buid);
}
