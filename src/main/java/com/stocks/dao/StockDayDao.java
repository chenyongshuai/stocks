package com.stocks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.stocks.entity.StockDay;
import com.stocks.vo.StockDayVO;



/** @author:  v_chenyongshuai@:
  * @date:  2018��7��16�� ����9:56:33 
  * @version��   1.0.0
  * @describe:    
  */
public interface StockDayDao {
	/**
	 * 
	 * @param sdd
	 * @return int
	 */
	int addStockDay(StockDay sdd);
	
	/**
	 * 
	 * @param buid
	 * @return List<StockDay>
	 */
	List<StockDay> getByBuid(String buid);
	
	/**
	 * 
	 * @param stockBuid
	 * @return StockDay
	 */
	@Select("select buid,detail_day,open_price,close_price,change_price,change_percent,low_price,top_price,deal_count,deal_amount,tun_percent from base_stock_detail_day where buid = #{stockBuid} and detail_day =#{detailDay}")
	StockDay getByStockBuidNow(@Param(value="stockBuid")String stockBuid, @Param(value="detailDay")String detailDay);
	
	@Select("select a.buid,stock_no,stock_cn_name,stock_eng_name,stock_type,detail_day,open_price,close_price,change_price,change_percent,low_price,top_price,deal_count,deal_amount,tun_percent from base_stock_detail_day a left join base_stock b on a.buid=b.buid where a.buid = #{stockBuid} and a.detail_day =#{detailDay}")
	StockDayVO getByBuidNow(@Param(value="stockBuid")String stockBuid, @Param(value="detailDay")String detailDay);
	
	@Select("select a.buid,stock_no,stock_cn_name,stock_eng_name,stock_type,detail_day,open_price,close_price,change_price,change_percent,low_price,top_price,deal_count,deal_amount,tun_percent from base_stock_detail_day a left join base_stock b on a.buid=b.buid where a.buid = #{stockBuid} and a.detail_day = (select max(detail_day) detail_day from base_stock_detail_day where buid =#{stockBuid})")
	StockDayVO getByBuidLast(String stockBuid);
	
	@Select("select buid,detail_day from base_stock_detail_day where buid=#{stockBuid} and detail_day=#{detailDay}")
	StockDay getByBuidAndDay(@Param(value="stockBuid")String stockBuid, @Param(value="detailDay")String detailDay);
}
