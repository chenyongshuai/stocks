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
	private Double openPrice;
	private Double closePrice;
	private Double changePrice;
	private String changePercent ;
	private Double lowPrice ;
	private Double topPrice ;
	private Double dealCount;
	private Double dealAmount;
	private String tunPercent;
	private Double dif;
	private Double dea;
	private Double macd;
	private Double ma60;
	private Double ma120;
	private Double ma250;
	private String createDate;
	private String updateDate;
	public StockDay() {
		super();
		
	}
	public StockDay(String buid, String detailDay, Double openPrice, Double closePrice, Double changePrice,
			String changePercent, Double lowPrice, Double topPrice, Double dealCount, Double dealAmount,
			String tunPercent, Double dif, Double dea, Double macd, Double ma60, Double ma120, Double ma250,
			String createDate, String updateDate) {
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
		this.dif = dif;
		this.dea = dea;
		this.macd = macd;
		this.ma60 = ma60;
		this.ma120 = ma120;
		this.ma250 = ma250;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "StockDay [buid=" + buid + ", detailDay=" + detailDay + ", openPrice=" + openPrice + ", closePrice="
				+ closePrice + ", changePrice=" + changePrice + ", changePercent=" + changePercent + ", lowPrice="
				+ lowPrice + ", topPrice=" + topPrice + ", dealCount=" + dealCount + ", dealAmount=" + dealAmount
				+ ", tunPercent=" + tunPercent + ", dif=" + dif + ", dea=" + dea + ", macd=" + macd + ", ma60=" + ma60
				+ ", ma120=" + ma120 + ", ma250=" + ma250 + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ "]";
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
	public Double getChangePrice() {
		return changePrice;
	}
	public void setChangePrice(Double changePrice) {
		this.changePrice = changePrice;
	}
	public String getChangePercent() {
		return changePercent;
	}
	public void setChangePercent(String changePercent) {
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
	public String getTunPercent() {
		return tunPercent;
	}
	public void setTunPercent(String tunPercent) {
		this.tunPercent = tunPercent;
	}
	public Double getDif() {
		return dif;
	}
	public void setDif(Double dif) {
		this.dif = dif;
	}
	public Double getDea() {
		return dea;
	}
	public void setDea(Double dea) {
		this.dea = dea;
	}
	public Double getMacd() {
		return macd;
	}
	public void setMacd(Double macd) {
		this.macd = macd;
	}
	public Double getMa60() {
		return ma60;
	}
	public void setMa60(Double ma60) {
		this.ma60 = ma60;
	}
	public Double getMa120() {
		return ma120;
	}
	public void setMa120(Double ma120) {
		this.ma120 = ma120;
	}
	public Double getMa250() {
		return ma250;
	}
	public void setMa250(Double ma250) {
		this.ma250 = ma250;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
