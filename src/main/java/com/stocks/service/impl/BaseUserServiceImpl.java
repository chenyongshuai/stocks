package com.stocks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocks.dao.BaseUserDao;
import com.stocks.entity.BaseUser;
import com.stocks.service.BaseUserService;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月20日 下午6:22:51 
  * @version：   1.0.0
  * @describe:    
  */
@Service
public class BaseUserServiceImpl implements BaseUserService {

	@Autowired
	private BaseUserDao dao;
	@Override
	public Boolean getByUser(BaseUser user) {
		BaseUser bsUser = dao.getByUser(user);
		if(bsUser!=null){
			return true;
		}
		return false;
	}
	
	
	@Override
	public boolean getByUserMobile(String userMobileNo) {
		BaseUser baseUser = dao.getByUsername(userMobileNo);
		//System.out.println(baseUser);
		if(baseUser!=null){
			return true;
		}
		return false;
	}


	@Override
	public boolean getByNickName(String nickName) {
		BaseUser baseUser = dao.getByNickName(nickName);
		//System.out.println(baseUser);
		if(baseUser!=null){
			return true;
		}
		return false;
	}


	@Override
	public boolean addUser(BaseUser user) {
		int addUser = dao.addUser(user);
		if(addUser==1){
			return true;
		}
		return false;
	}

}
