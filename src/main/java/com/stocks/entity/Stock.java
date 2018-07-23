package com.stocks.entity;

import java.io.Serializable;
import java.util.Date;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月15日 下午7:14:48 
  * @version：   1.0.0
  * @describe:    
  */
public class Stock implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5904207121863544476L;
	private String buid;
	private String stockNo;
	private String stockCnName;
	private String stockEngName;
	private String stockType;
	private Date createDate;
    private String createBy;
    private Date updateDate;
    private String updateBy;
	public Stock() {
		super();
		
	}
	public Stock(String buid, String stockNo, String stockCnName, String stockEngName, String stockType,
			Date createDate, String createBy, Date updateDate, String updateBy) {
		super();
		this.buid = buid;
		this.stockNo = stockNo;
		this.stockCnName = stockCnName;
		this.stockEngName = stockEngName;
		this.stockType = stockType;
		this.createDate = createDate;
		this.createBy = createBy;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
	}
	@Override
	public String toString() {
		return "Stock [buid=" + buid + ", stockNo=" + stockNo + ", stockCnName=" + stockCnName + ", stockEngName="
				+ stockEngName + ", stockType=" + stockType + ", createDate=" + createDate + ", createBy=" + createBy
				+ ", updateDate=" + updateDate + ", updateBy=" + updateBy + "]";
	}
	public String getBuid() {
		return buid;
	}
	public void setBuid(String buid) {
		this.buid = buid;
	}
	public String getStockNo() {
		return stockNo;
	}
	public void setStockNo(String stockNo) {
		this.stockNo = stockNo;
	}
	public String getStockCnName() {
		return stockCnName;
	}
	public void setStockCnName(String stockCnName) {
		this.stockCnName = stockCnName;
	}
	public String getStockEngName() {
		return stockEngName;
	}
	public void setStockEngName(String stockEngName) {
		this.stockEngName = stockEngName;
	}
	public String getStockType() {
		return stockType;
	}
	public void setStockType(String stockType) {
		this.stockType = stockType;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
    
}
