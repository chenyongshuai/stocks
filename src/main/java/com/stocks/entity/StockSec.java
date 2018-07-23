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
	  private Double currentPrice;
	  private String changePrice;
	  private Integer dealCount ;
	  private Integer dealAmount;
	  private Date createDate;
	  private String createBy ;
	  private Date updateDate ;
	  private String updateBy ;
	public StockSec() {
		super();
		
	}
	public StockSec(String buid, String detailTime, String detailDate, Double currentPrice, String changePrice,
			Integer dealCount, Integer dealAmount, Date createDate, String createBy, Date updateDate, String updateBy) {
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
	@Override
	public String toString() {
		return "StockSec [buid=" + buid + ", detailTime=" + detailTime + ", detailDate=" + detailDate
				+ ", currentPrice=" + currentPrice + ", changePrice=" + changePrice + ", dealCount=" + dealCount
				+ ", dealAmount=" + dealAmount + ", createDate=" + createDate + ", createBy=" + createBy
				+ ", updateDate=" + updateDate + ", updateBy=" + updateBy + "]";
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
	public Double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public String getChangePrice() {
		return changePrice;
	}
	public void setChangePrice(String changePrice) {
		this.changePrice = changePrice;
	}
	public Integer getDealCount() {
		return dealCount;
	}
	public void setDealCount(Integer dealCount) {
		this.dealCount = dealCount;
	}
	public Integer getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(Integer dealAmount) {
		this.dealAmount = dealAmount;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
