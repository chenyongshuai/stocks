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
	private Double   openPrice;
	private Double  closePrice;
	private String   changePrice;
	private Double   changePercent ;
	private Double   lowPrice ;
	private Double   topPrice ;
	private Double   dealCount;
	private Double   dealAmount;
	private Double 	tunPercent;
	public StockDayVO() {
		super();
		
	}
	public StockDayVO(String buid, String stockNo, String stockCnName, String stockEngName, String stockType,
			String detailDay, Double openPrice, Double closePrice, String changePrice, Double changePercent,
			Double lowPrice, Double topPrice, Double dealCount, Double dealAmount, Double tunPercent) {
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
	}
	@Override
	public String toString() {
		return "StockDayVO [buid=" + buid + ", stockNo=" + stockNo + ", stockCnName=" + stockCnName + ", stockEngName="
				+ stockEngName + ", stockType=" + stockType + ", detailDay=" + detailDay + ", openPrice=" + openPrice
				+ ", closePrice=" + closePrice + ", changePrice=" + changePrice + ", changePercent=" + changePercent
				+ ", lowPrice=" + lowPrice + ", topPrice=" + topPrice + ", dealCount=" + dealCount + ", dealAmount="
				+ dealAmount + ", tunPercent=" + tunPercent + "]";
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
	public Double getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(Double openPrice) {
		this.openPrice = openPrice;
	}
	public Double getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(Double closePrice) {
		this.closePrice = closePrice;
	}
	public String getChangePrice() {
		return changePrice;
	}
	public void setChangePrice(String changePrice) {
		this.changePrice = changePrice;
	}
	public Double getChangePercent() {
		return changePercent;
	}
	public void setChangePercent(Double changePercent) {
		this.changePercent = changePercent;
	}
	public Double getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(Double lowPrice) {
		this.lowPrice = lowPrice;
	}
	public Double getTopPrice() {
		return topPrice;
	}
	public void setTopPrice(Double topPrice) {
		this.topPrice = topPrice;
	}
	public Double getDealCount() {
		return dealCount;
	}
	public void setDealCount(Double dealCount) {
		this.dealCount = dealCount;
	}
	public Double getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(Double dealAmount) {
		this.dealAmount = dealAmount;
	}
	public Double getTunPercent() {
		return tunPercent;
	}
	public void setTunPercent(Double tunPercent) {
		this.tunPercent = tunPercent;
	}

}
