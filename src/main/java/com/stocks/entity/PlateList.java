package com.stocks.entity;

import java.io.Serializable;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月21日 下午2:17:10 
  * @version：   1.0.0
  * @describe:    
  */
public class PlateList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2813257224831636266L;
	private String plateBuid;
	private String stockBuid;
	private double addPrice;
	private String createDate;
	public PlateList() {
		super();
		
	}
	public PlateList(String plateBuid, String stockBuid, double addPrice, String createDate) {
		super();
		this.plateBuid = plateBuid;
		this.stockBuid = stockBuid;
		this.addPrice = addPrice;
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "PlateList [plateBuid=" + plateBuid + ", stockBuid=" + stockBuid + ", addPrice=" + addPrice
				+ ", createDate=" + createDate + "]";
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
	public double getAddPrice() {
		return addPrice;
	}
	public void setAddPrice(double addPrice) {
		this.addPrice = addPrice;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
