package com.stocks.entity;

import java.io.Serializable;

/** @author:  v_chenyongshuai@:
  * @date:  2018��7��16�� ����9:35:02 
  * @version��   1.0.0
  * @describe:    
  */
public class StockDay implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4141142631144845272L;
	private String buid;
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
	private String createDate;
	private String createBy;
	private String updateDate;
    private String updateBy;
	public StockDay() {
		super();
		
	}
	public StockDay(String buid, String detailDay, Double openPrice, Double closePrice, String changePrice,
			Double changePercent, Double lowPrice, Double topPrice, Double dealCount, Double dealAmount,
			Double tunPercent, String createDate, String createBy, String updateDate, String updateBy) {
		super();
		this.buid = buid;
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
		this.createDate = createDate;
		this.createBy = createBy;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
	}
	@Override
	public String toString() {
		return "StockDay [buid=" + buid + ", detailDay=" + detailDay + ", openPrice=" + openPrice + ", closePrice="
				+ closePrice + ", changePrice=" + changePrice + ", changePercent=" + changePercent + ", lowPrice="
				+ lowPrice + ", topPrice=" + topPrice + ", dealCount=" + dealCount + ", dealAmount=" + dealAmount
				+ ", tunPercent=" + tunPercent + ", createDate=" + createDate + ", createBy=" + createBy
				+ ", updateDate=" + updateDate + ", updateBy=" + updateBy + "]";
	}
	public String getBuid() {
		return buid;
	}
	public void setBuid(String buid) {
		this.buid = buid;
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
