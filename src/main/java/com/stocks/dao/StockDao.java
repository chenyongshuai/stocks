package com.stocks.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	
	
	/**
	 * 
	 * @return List<Stock>
	 */
	@Select("select buid,stock_no,stock_cn_name,stock_eng_name from base_stock order by stock_no")
	List<Stock> getAll();
	
	@Update("update base_stock set stock_eng_name=#{stockEngName} where buid=#{buid}")
	int updateStock(@Param(value="stockEngName")String stockEngName, @Param(value="buid")String buid);
	
	@Update("update base_stock set stock_cn_name=#{stockCnName},stock_trade=#{stockTrade},stock_loc=#{stockLoc},update_date=CURRENT_TIMESTAMP where stock_no=#{stockNo}")
	int updateStockByNo(Stock stock);
}
