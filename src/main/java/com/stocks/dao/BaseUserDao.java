package com.stocks.dao;

import org.apache.ibatis.annotations.Select;

import com.stocks.entity.BaseUser;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月20日 下午6:10:16 
  * @version：   1.0.0
  * @describe:    
  */
public interface BaseUserDao {
	
	/**
	 * 
	 * @param user
	 * @return BaseUser
	 */
	@Select("SELECT * FROM base_user where user_name=#{userName} and user_pwd=#{userPwd}")
	BaseUser getByUser(BaseUser user);
	
}
