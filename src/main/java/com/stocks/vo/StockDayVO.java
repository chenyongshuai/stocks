package com.stocks.vo;

import java.io.Serializable;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月21日 下午10:16:11 
  * @version：   1.0.0
  * @describe:    
  */
public class StockDayVO implements Serializable{
	private String buid;
	private String stockNo;
	private String stockCnName;
	private String stockEngName;
	private String stockType;
	private String detailDay;
	private double openPrice;
	private double closePrice;
	private String changePrice;
	private double changePercent;
	private double lowPrice ;
	private double topPrice ;
	private double dealCount;
	private double dealAmount;
	private double tunPercent;
	private String addEarn;
	public StockDayVO(String buid, String stockNo, String stockCnName, String stockEngName, String stockType,
			String detailDay, double openPrice, double closePrice, String changePrice, double changePercent,
			double lowPrice, double topPrice, double dealCount, double dealAmount, double tunPercent, String addEarn) {
		super();
		this.buid = buid;
		this.stockNo = stockNo;
		this.stockCnName = stockCnName;
		this.stockEngName = stockEngName;
		this.stockType = stockType;
		this.detailDay = detailDay;
		this.openPrice = openPrice;
		this.closePrice = closePrice;
		this.changePrice = changePrice;
		this.changePercent = changePercent;
		this.lowPrice = lowPrice;
		this.topPrice = topPrice;
		this.dealCount = dealCount;
		this.dealAmount = dealAmount;
		this.tunPercent = tunPercent;
		this.addEarn = addEarn;
	}
	public StockDayVO() {
		super();
		
	}
	@Override
	public String toString() {
		return "StockDayVO [buid=" + buid + ", stockNo=" + stockNo + ", stockCnName=" + stockCnName + ", stockEngName="
				+ stockEngName + ", stockType=" + stockType + ", detailDay=" + detailDay + ", openPrice=" + openPrice
				+ ", closePrice=" + closePrice + ", changePrice=" + changePrice + ", changePercent=" + changePercent
				+ ", lowPrice=" + lowPrice + ", topPrice=" + topPrice + ", dealCount=" + dealCount + ", dealAmount="
				+ dealAmount + ", tunPercent=" + tunPercent + ", addEarn=" + addEarn + "]";
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
	public String getDetailDay() {
		return detailDay;
	}
	public void setDetailDay(String detailDay) {
		this.detailDay = detailDay;
	}
	public double getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}
	public double getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(double closePrice) {
		this.closePrice = closePrice;
	}
	public String getChangePrice() {
		return changePrice;
	}
	public void setChangePrice(String changePrice) {
		this.changePrice = changePrice;
	}
	public double getChangePercent() {
		return changePercent;
	}
	public void setChangePercent(double changePercent) {
		this.changePercent = changePercent;
	}
	public double getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}
	public double getTopPrice() {
		return topPrice;
	}
	public void setTopPrice(double topPrice) {
		this.topPrice = topPrice;
	}
	public double getDealCount() {
		return dealCount;
	}
	public void setDealCount(double dealCount) {
		this.dealCount = dealCount;
	}
	public double getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(double dealAmount) {
		this.dealAmount = dealAmount;
	}
	public double getTunPercent() {
		return tunPercent;
	}
	public void setTunPercent(double tunPercent) {
		this.tunPercent = tunPercent;
	}
	public String getAddEarn() {
		return addEarn;
	}
	public void setAddEarn(String addEarn) {
		this.addEarn = addEarn;
	}
	
}
