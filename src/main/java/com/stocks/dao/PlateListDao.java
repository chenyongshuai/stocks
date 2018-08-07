package com.stocks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.stocks.entity.PlateList;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月21日 下午2:18:59 
  * @version：   1.0.0
  * @describe:    
  */
public interface PlateListDao {
	/**
	 * 
	 * @param plateBuid
	 * @return List<PlateList>
	 */
	@Select("Select stock_buid from base_plate_list where plate_buid=#{plateBuid}")
	List<PlateList> getPlateList(String plateBuid);
	
	/**
	 * 
	 * @param plateBuid
	 * @return int
	 */
	@Select("select count(*) count from base_plate_list where plate_buid=#{plateBuid}")
	int getPlateListCount(String plateBuid);
	
	/**
	 * 
	 * @param plateBuid
	 * @param buid
	 * @return int
	 */
	@Insert("insert into base_plate_list values(#{plateBuid}, #{buid}, CURRENT_TIMESTAMP)")
	int addStockList(@Param(value="plateBuid")String plateBuid, @Param(value="buid")String buid);
	
	/**
	 * 
	 * @param plateBuid
	 * @param buid
	 * @return PlateList
	 */
	@Select("select plate_buid,stock_buid from base_plate_list where plate_buid=#{plateBuid} and stock_buid=#{buid}")
	PlateList getByPlateAndStock(@Param(value="plateBuid")String plateBuid, @Param(value="buid")String buid);
	
	
	/**
	 * 
	 * @param plateBuid
	 * @param buid
	 * @return PlateList // and plate_buid=#{plateBuid}
	 */
	@Delete("<script>delete from base_plate_list where  plate_buid=#{plateBuid} and stock_buid in <foreach collection=\"buidList\" open=\"(\" close=\")\" item=\"buid\" separator=\",\">#{buid}</foreach></script>")
	int delByPlateAndStock(@Param(value="buidList") String[] buidList,@Param("plateBuid")String plateBuid);
	
}
