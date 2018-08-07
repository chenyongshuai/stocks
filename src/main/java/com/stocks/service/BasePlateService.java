package com.stocks.service;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import com.stocks.entity.BasePlate;

/** @author:  v_chenyongshuai@:
  * @date:  2018年8月5日 上午10:22:14 
  * @version：   1.0.0
  * @describe:    
  */
public interface BasePlateService {
	/**
	 * 
	 * @param userNo
	 * @return List<BasePlate>
	 */
	Map<String, Object> getPlateList(String userNo);
	/**
	 * 
	 * @param plate
	 * @return boolean
	 */
	boolean addPlate(BasePlate plate);
	
	/**
	 * 
	 * @param plate
	 * @return boolean
	 */
	boolean editPlate(BasePlate plate);
	
	
	/**
	 * 
	 * @param plateBuid
	 * @return boolean
	 */
	boolean delPlate(String[] buidList);
	
	
}
