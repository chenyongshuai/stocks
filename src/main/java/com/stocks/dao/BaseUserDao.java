package com.stocks.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
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
	@Select("select buid,user_name,user_nick_name,user_birthday,user_mobile_no from (select buid,user_name,user_pwd,user_nick_name,user_birthday,user_mobile_no from base_user where user_name=#{userName} or user_mobile_no=#{userName}) a where a.user_pwd =#{userPwd}")
	BaseUser getByUser(BaseUser user);
	
	/**
	 * 
	 * @param username
	 * @return BaseUser
	 */
	@Select("select buid from base_user where user_mobile_no=#{userMobileNo}")
	BaseUser getByUsername(@Param(value="userMobileNo")String userMobileNo);
	
	/**
	 * 
	 * @param nickName
	 * @return BaseUser
	 */
	@Select("select buid from base_user where user_nick_name=#{nickName}")
	BaseUser getByNickName(@Param(value="nickName")String nickName);
	
	/**
	 * 
	 * @param user
	 * @return int
	 */
	@Insert("insert into base_user values(UUID(),#{userName},#{userPwd},#{userNickName},#{userBirthday},#{userMobileNo},CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)")
	int addUser(BaseUser user);
	
	
}
