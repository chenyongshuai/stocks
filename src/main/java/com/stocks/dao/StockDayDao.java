package com.stocks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.stocks.entity.Stock;
import com.stocks.entity.StockDay;
import com.stocks.vo.StockDayVO;




public interface StockDayDao {
	/**
	 * 
	 * @param sdd
	 * @return int
	 */
	@Insert("insert into base_stock_day values(#{buid},#{detailDay},#{openPrice},#{closePrice},#{changePrice},#{changePercent},#{lowPrice},#{topPrice},#{dealCount},#{dealAmount},#{tunPercent},#{dif},#{dea},#{macd},current_timestamp,#{createBy},current_timestamp,#{updateBy})")
	int addStockDay(StockDay sdd);
	
	@Select("select distinct buid from base_stock_day")
	List<Stock> getBuidDistinc();
	/**
	 * 
	 * @param buid
	 * @return List<StockDay>
	 */
	@Select("select buid,detail_day,open_price,close_price,low_price,top_price,deal_count,dif,dea,macd,ma60,ma120,ma250 from base_stock_day where buid = #{buid} order by detail_day")
	List<StockDay> getByBuid(String buid);
	
	@Select("select buid,detail_day,open_price,close_price,low_price,top_price,deal_count,dif,dea,macd,ma60,ma120,ma250 from base_stock_day where buid = #{buid} and detail_day >= #{detailDay} order by detail_day")
	List<StockDay> getListByBuidAndDay(@Param(value="buid")String buid, @Param(value="detailDay")String detailDay);
	
	/**
	 * 
	 * @param buid
	 * @return List<StockDay>
	 */
	@Select("select buid,detail_day,close_price from base_stock_day where buid = #{buid} order by detail_day")
	List<StockDay> getClosePriceAndDetailByBuid(String buid);
	/**
	 * 
	 * @param stockBuid
	 * @return StockDay
	 */
	@Select("select buid,detail_day,open_price,close_price,change_price,change_percent,low_price,top_price,deal_count,deal_amount,tun_percent from base_stock_detail_day where buid = #{stockBuid} and detail_day =#{detailDay}")
	StockDay getByStockBuidNow(@Param(value="stockBuid")String stockBuid, @Param(value="detailDay")String detailDay);
	
	/**
	 * 
	 * @param stockBuid
	 * @param detailDay
	 * @return StockDayVO
	 */
	@Select("select a.buid,stock_no,stock_cn_name,stock_eng_name,stock_type,detail_day,open_price,close_price,change_price,change_percent,low_price,top_price,deal_count,deal_amount,tun_percent from base_stock_detail_day a left join base_stock b on a.buid=b.buid where a.buid = #{stockBuid} and a.detail_day =#{detailDay}")
	StockDayVO getByBuidNow(@Param(value="stockBuid")String stockBuid, @Param(value="detailDay")String detailDay);
	/**
	 * 
	 * @param stockBuid
	 * @return StockDayVO
	 */
	@Select("select a.buid,stock_no,stock_cn_name,stock_eng_name,stock_type,detail_day,open_price,close_price,change_price,change_percent,low_price,top_price,deal_count,deal_amount,tun_percent from base_stock_detail_day a left join base_stock b on a.buid=b.buid where a.buid = #{stockBuid} and a.detail_day = (select max(detail_day) detail_day from base_stock_detail_day where buid =#{stockBuid})")
	StockDayVO getByBuidLast(String stockBuid);
	/**
	 * 
	 * @param stockBuid
	 * @param detailDay
	 * @return StockDay
	 */
	@Select("select buid,detail_day from base_stock_detail_day where buid=#{stockBuid} and detail_day=#{detailDay}")
	StockDay getByBuidAndDay(@Param(value="stockBuid")String stockBuid, @Param(value="detailDay")String detailDay);
	/**
	 * 
	 * @param buid
	 * @return StockDay
	 */
	@Select("select buid,close_price,DATE_FORMAT(detail_day,'%Y%m%d') detail_day,UNIX_TIMESTAMP(update_date) update_date from base_stock_detail_day where detail_day=(select max(detail_day) detail_day from base_stock_detail_day where buid=#{buid}) and buid=#{buid}")
	StockDay getLastByBuid(@Param(value="buid")String buid);
	/**
	 * 
	 * @param buid
	 * @param detailDay
	 * @param dif
	 * @param dea
	 * @param macd
	 * @return int
	 */
	@Update("update base_stock_day set dif=#{dif},dea=#{dea},macd=#{macd},ma60=#{ma60},ma120=#{ma120},ma250=#{ma250},update_date=current_timestamp where buid=#{buid} and detail_day=#{detailDay}")
	int updateMacdByBuidAndDetailDay(@Param(value="buid")String buid, @Param(value="detailDay")String detailDay,@Param(value="dif")String dif,@Param(value="dea")String dea, @Param(value="macd")String macd, @Param(value="ma60")String ma60, @Param(value="ma120")String ma120, @Param(value="ma250")String ma250);
	
	@Select("<script>select a.buid,a.stock_no,a.stock_cn_name,b.block_cn_name stock_trade,a.stock_loc,a.stock_pb,a.stock_pe,a.stock_flow,a.stock_total from base_stock a, base_block b where a.buid in <foreach collection=\"buidList\" open=\"(\" close=\")\" item=\"buid\" separator=\",\">#{buid}</foreach> and a.stock_block = b.buid</script>")
	List<Stock> getStockDayVoByBuid(@Param(value="buidList")String[] buidList);
	
	
	
	
	
	
	
	
}
