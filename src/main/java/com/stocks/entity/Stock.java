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
	private String stockTrade;
	private String stockLoc;
	private String stockPb;
	private String stockPe;
	private String stockFlow;
	private String stockFlowAmount;
	private String stockTotal;
	private String stockTotalAmount;
	private String launchDate;
	private String createDate;
    private String createBy;
    public boolean equals(Object anObject) {
		return buid.equals(anObject);
	}
	private String updateDate;
    private String updateBy;
	public Stock() {
		super();
		
	}
	public Stock(String buid, String stockNo, String stockCnName, String stockEngName, String stockType,
			String stockTrade, String stockLoc, String stockPb, String stockPe, String stockFlow,
			String stockFlowAmount, String stockTotal, String stockTotalAmount, String launchDate, String createDate,
			String createBy, String updateDate, String updateBy) {
		super();
		this.buid = buid;
		this.stockNo = stockNo;
		this.stockCnName = stockCnName;
		this.stockEngName = stockEngName;
		this.stockType = stockType;
		this.stockTrade = stockTrade;
		this.stockLoc = stockLoc;
		this.stockPb = stockPb;
		this.stockPe = stockPe;
		this.stockFlow = stockFlow;
		this.stockFlowAmount = stockFlowAmount;
		this.stockTotal = stockTotal;
		this.stockTotalAmount = stockTotalAmount;
		this.launchDate = launchDate;
		this.createDate = createDate;
		this.createBy = createBy;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
	}
	@Override
	public String toString() {
		return "Stock [buid=" + buid + ", stockNo=" + stockNo + ", stockCnName=" + stockCnName + ", stockEngName="
				+ stockEngName + ", stockType=" + stockType + ", stockTrade=" + stockTrade + ", stockLoc=" + stockLoc
				+ ", stockPb=" + stockPb + ", stockPe=" + stockPe + ", stockFlow=" + stockFlow + ", stockFlowAmount="
				+ stockFlowAmount + ", stockTotal=" + stockTotal + ", stockTotalAmount=" + stockTotalAmount
				+ ", launchDate=" + launchDate + ", createDate=" + createDate + ", createBy=" + createBy
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
	public String getStockTrade() {
		return stockTrade;
	}
	public void setStockTrade(String stockTrade) {
		this.stockTrade = stockTrade;
	}
	public String getStockLoc() {
		return stockLoc;
	}
	public void setStockLoc(String stockLoc) {
		this.stockLoc = stockLoc;
	}
	public String getStockPb() {
		return stockPb;
	}
	public void setStockPb(String stockPb) {
		this.stockPb = stockPb;
	}
	public String getStockPe() {
		return stockPe;
	}
	public void setStockPe(String stockPe) {
		this.stockPe = stockPe;
	}
	public String getStockFlow() {
		return stockFlow;
	}
	public void setStockFlow(String stockFlow) {
		this.stockFlow = stockFlow;
	}
	public String getStockFlowAmount() {
		return stockFlowAmount;
	}
	public void setStockFlowAmount(String stockFlowAmount) {
		this.stockFlowAmount = stockFlowAmount;
	}
	public String getStockTotal() {
		return stockTotal;
	}
	public void setStockTotal(String stockTotal) {
		this.stockTotal = stockTotal;
	}
	public String getStockTotalAmount() {
		return stockTotalAmount;
	}
	public void setStockTotalAmount(String stockTotalAmount) {
		this.stockTotalAmount = stockTotalAmount;
	}
	public String getLaunchDate() {
		return launchDate;
	}
	public void setLaunchDate(String launchDate) {
		this.launchDate = launchDate;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
