package com.stocks.dao;

import java.util.List;

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
	
	@Select("select count(*) count from base_plate_list where plate_buid=#{plateBuid}")
	int getPlateListCount(String plateBuid);
}
