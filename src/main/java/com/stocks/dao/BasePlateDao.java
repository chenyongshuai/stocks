package com.stocks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.stocks.entity.BasePlate;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月21日 下午1:32:50 
  * @version：   1.0.0
  * @describe:    
  */
public interface BasePlateDao {
	
	@Select("select buid,plate_name,plate_desc,plate_no,user_no from base_plate where user_no=#{userNo} and buid=#{buid}")
	List<BasePlate> getByUser(@Param(value="userNo")String userNo, @Param(value="buid")String buid);
}
