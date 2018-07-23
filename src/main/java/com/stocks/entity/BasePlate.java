package com.stocks.entity;

import java.io.Serializable;
import java.util.List;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月21日 下午1:30:31 
  * @version：   1.0.0
  * @describe:    
  */
public class BasePlate implements Serializable{
	private String buid;
	private String plateName;
	private String plateDesc;
	private String plateNo;
	private String userNo;
	private String createDate;
	private String updateDate;
	private List<Stock> stocks;
	public BasePlate() {
		super();
		
	}
	public BasePlate(String buid, String plateName, String plateDesc, String plateNo, String userNo, String createDate,
			String updateDate, List<Stock> stocks) {
		super();
		this.buid = buid;
		this.plateName = plateName;
		this.plateDesc = plateDesc;
		this.plateNo = plateNo;
		this.userNo = userNo;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.stocks = stocks;
	}
	@Override
	public String toString() {
		return "BasePlate [buid=" + buid + ", plateName=" + plateName + ", plateDesc=" + plateDesc + ", plateNo="
				+ plateNo + ", userNo=" + userNo + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ ", stocks=" + stocks + "]";
	}
	public String getBuid() {
		return buid;
	}
	public void setBuid(String buid) {
		this.buid = buid;
	}
	public String getPlateName() {
		return plateName;
	}
	public void setPlateName(String plateName) {
		this.plateName = plateName;
	}
	public String getPlateDesc() {
		return plateDesc;
	}
	public void setPlateDesc(String plateDesc) {
		this.plateDesc = plateDesc;
	}
	public String getPlateNo() {
		return plateNo;
	}
	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public List<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	
	
}
