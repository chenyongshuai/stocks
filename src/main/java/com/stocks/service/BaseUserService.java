package com.stocks.service;

import com.stocks.entity.BaseUser;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月20日 下午6:21:50 
  * @version：   1.0.0
  * @describe:    
  */
public interface BaseUserService {
	/**
	 * 
	 * @param user
	 * @return BaseUser
	 */
	Boolean getByUser(BaseUser user);
	
	/**
	 * 
	 * @param userMobileNo
	 * @return BaseUser
	 */
	boolean getByUserMobile(String userMobileNo);
	
	/**
	 * 
	 * @param nickName
	 * @return BaseUser
	 */
	boolean getByNickName(String nickName);
	
	/**
	 * 
	 * @param user
	 * @return boolean
	 */
	boolean addUser(BaseUser user);
}
