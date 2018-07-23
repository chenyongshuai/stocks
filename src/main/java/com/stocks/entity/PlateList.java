package com.stocks.entity;

import java.io.Serializable;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月21日 下午2:17:10 
  * @version：   1.0.0
  * @describe:    
  */
public class PlateList implements Serializable{
	private String plateBuid;
	private String stockBuid;
	private String createDate;
	public PlateList() {
		super();
		
	}
	public PlateList(String plateBuid, String stockBuid, String createDate) {
		super();
		this.plateBuid = plateBuid;
		this.stockBuid = stockBuid;
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "PlateList [plateBuid=" + plateBuid + ", stockBuid=" + stockBuid + ", createDate=" + createDate + "]";
	}
	public String getPlateBuid() {
		return plateBuid;
	}
	public void setPlateBuid(String plateBuid) {
		this.plateBuid = plateBuid;
	}
	public String getStockBuid() {
		return stockBuid;
	}
	public void setStockBuid(String stockBuid) {
		this.stockBuid = stockBuid;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}
