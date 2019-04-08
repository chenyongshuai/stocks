package com.stocks.entity;

import java.io.Serializable;
import java.util.Date;

/** @author:  v_chenyongshuai@:
  * @date:  2018��7��15�� ����8:50:10 
  * @version��   1.0.0
  * @describe:    
  */
public class StockSec implements Serializable{
	  /**
	 * 
	 */
	private static final long serialVersionUID = -7765175076551741744L;
	private String buid;
	  private String detailTime;
	  private String detailDate;
	  private double currentPrice;
	  private String changePrice;
	  private int dealCount ;
	  private int dealAmount;
	  private String createDate;
	  private String createBy ;
	  private String updateDate ;
	  private String updateBy ;
	@Override
	public String toString() {
		return "StockSec [buid=" + buid + ", detailTime=" + detailTime + ", detailDate=" + detailDate
				+ ", currentPrice=" + currentPrice + ", changePrice=" + changePrice + ", dealCount=" + dealCount
				+ ", dealAmount=" + dealAmount + ", createDate=" + createDate + ", createBy=" + createBy
				+ ", updateDate=" + updateDate + ", updateBy=" + updateBy + "]";
	}
	public StockSec() {
		super();
		
	}
	public StockSec(String buid, String detailTime, String detailDate, double currentPrice, String changePrice,
			int dealCount, int dealAmount, String createDate, String createBy, String updateDate, String updateBy) {
		super();
		this.buid = buid;
		this.detailTime = detailTime;
		this.detailDate = detailDate;
		this.currentPrice = currentPrice;
		this.changePrice = changePrice;
		this.dealCount = dealCount;
		this.dealAmount = dealAmount;
		this.createDate = createDate;
		this.createBy = createBy;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
	}
	public String getBuid() {
		return buid;
	}
	public void setBuid(String buid) {
		this.buid = buid;
	}
	public String getDetailTime() {
		return detailTime;
	}
	public void setDetailTime(String detailTime) {
		this.detailTime = detailTime;
	}
	public String getDetailDate() {
		return detailDate;
	}
	public void setDetailDate(String detailDate) {
		this.detailDate = detailDate;
	}
	public double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public String getChangePrice() {
		return changePrice;
	}
	public void setChangePrice(String changePrice) {
		this.changePrice = changePrice;
	}
	public int getDealCount() {
		return dealCount;
	}
	public void setDealCount(int dealCount) {
		this.dealCount = dealCount;
	}
	public int getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(int dealAmount) {
		this.dealAmount = dealAmount;
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
