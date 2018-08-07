package com.stocks.entity;

import java.io.Serializable;
import java.util.List;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月24日 下午1:23:07 
  * @version：   1.0.0
  * @describe:    
  */
public class BaseResource implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8279143403838678515L;
	private String buid;
	private String showSeq;
	private String resCnTitle;
	private String resEngTitle;
	private String resParentId;
	private String resLevel;
	private String resType;
	private String resHref;
	private String resIcon;
	private String resContent;
	private String createDate;
	private String createBy;
	private String updateDate;
	private String updateBy;
	private List<BaseResource> sonResource;
	public BaseResource() {
		super();
		
	}
	public BaseResource(String buid, String showSeq, String resCnTitle, String resEngTitle, String resParentId,
			String resLevel, String resType, String resHref, String resIcon, String resContent, String createDate,
			String createBy, String updateDate, String updateBy, List<BaseResource> sonResource) {
		super();
		this.buid = buid;
		this.showSeq = showSeq;
		this.resCnTitle = resCnTitle;
		this.resEngTitle = resEngTitle;
		this.resParentId = resParentId;
		this.resLevel = resLevel;
		this.resType = resType;
		this.resHref = resHref;
		this.resIcon = resIcon;
		this.resContent = resContent;
		this.createDate = createDate;
		this.createBy = createBy;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
		this.sonResource = sonResource;
	}
	@Override
	public String toString() {
		return "BaseResource [buid=" + buid + ", showSeq=" + showSeq + ", resCnTitle=" + resCnTitle + ", resEngTitle="
				+ resEngTitle + ", resParentId=" + resParentId + ", resLevel=" + resLevel + ", resType=" + resType
				+ ", resHref=" + resHref + ", resIcon=" + resIcon + ", resContent=" + resContent + ", createDate="
				+ createDate + ", createBy=" + createBy + ", updateDate=" + updateDate + ", updateBy=" + updateBy
				+ ", sonResource=" + sonResource + "]";
	}
	public String getBuid() {
		return buid;
	}
	public void setBuid(String buid) {
		this.buid = buid;
	}
	public String getShowSeq() {
		return showSeq;
	}
	public void setShowSeq(String showSeq) {
		this.showSeq = showSeq;
	}
	public String getResCnTitle() {
		return resCnTitle;
	}
	public void setResCnTitle(String resCnTitle) {
		this.resCnTitle = resCnTitle;
	}
	public String getResEngTitle() {
		return resEngTitle;
	}
	public void setResEngTitle(String resEngTitle) {
		this.resEngTitle = resEngTitle;
	}
	public String getResParentId() {
		return resParentId;
	}
	public void setResParentId(String resParentId) {
		this.resParentId = resParentId;
	}
	public String getResLevel() {
		return resLevel;
	}
	public void setResLevel(String resLevel) {
		this.resLevel = resLevel;
	}
	public String getResType() {
		return resType;
	}
	public void setResType(String resType) {
		this.resType = resType;
	}
	public String getResHref() {
		return resHref;
	}
	public void setResHref(String resHref) {
		this.resHref = resHref;
	}
	public String getResIcon() {
		return resIcon;
	}
	public void setResIcon(String resIcon) {
		this.resIcon = resIcon;
	}
	public String getResContent() {
		return resContent;
	}
	public void setResContent(String resContent) {
		this.resContent = resContent;
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
	public List<BaseResource> getSonResource() {
		return sonResource;
	}
	public void setSonResource(List<BaseResource> sonResource) {
		this.sonResource = sonResource;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
