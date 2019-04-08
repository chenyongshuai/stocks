package com.stocks.service;
import java.util.Map;


/** @author:  v_chenyongshuai@:
  * @date:  2018年7月21日 下午4:26:02 
  * @version：   1.0.0
  * @describe:    
  */
public interface PlateListService {
	
	/**
	 * 
	 * @param plateBuid
	 * @return Map<String,Object>
	 */
	Map<String,Object> getListByPlate(String plateBuid);

	/**
	 * 
	 * @param plateBuid
	 * @param buidList
	 * @return boolean
	 */
	boolean delStockList(String plateBuid,  String[] buidList);
	
	/**
	 * 
	 * @param plateBuid
	 * @param buid
	 * @return boolean
	 */
	boolean addStockList(String plateBuid, String buid);
}
