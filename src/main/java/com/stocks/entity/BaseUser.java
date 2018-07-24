package com.stocks.entity;

import java.io.Serializable;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月20日 下午6:05:29 
  * @version：   1.0.0
  * @describe:    
  */
public class BaseUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7035066708207645982L;
	private String buid;
	private String userName;
	private String userPwd;
	private String userNickName;
	private String userBirthday;
	private String userMobileNo;
	private String createDate;
    private String createBy;
    private String updateDate;
    private String updateBy;
	@Override
	public String toString() {
		return "BaseUser [buid=" + buid + ", userName=" + userName + ", userPwd=" + userPwd + ", userNickName="
				+ userNickName + ", userBirthday=" + userBirthday + ", userMobileNo=" + userMobileNo + ", createDate="
				+ createDate + ", createBy=" + createBy + ", updateDate=" + updateDate + ", updateBy=" + updateBy + "]";
	}
	public BaseUser() {
		super();
		
	}
	public BaseUser(String buid, String userName, String userPwd, String userNickName, String userBirthday,
			String userMobileNo, String createDate, String createBy, String updateDate, String updateBy) {
		super();
		this.buid = buid;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userNickName = userNickName;
		this.userBirthday = userBirthday;
		this.userMobileNo = userMobileNo;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public String getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserMobileNo() {
		return userMobileNo;
	}
	public void setUserMobileNo(String userMobileNo) {
		this.userMobileNo = userMobileNo;
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
	
}
