package com.stocks.test.dao;

import java.util.UUID;

import org.apache.tomcat.jni.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.stocks.SpringBootApplication;
import com.stocks.dao.BaseUserDao;
import com.stocks.entity.BaseUser;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月20日 下午6:13:34 
  * @version：   1.0.0
  * @describe:    
  */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SpringBootApplication.class)
public class BaseUserDaoTest {
	@Autowired
	private BaseUserDao dao;
	@Test
	public void getByUser(){
		BaseUser user = new BaseUser();
		user.setUserName("public_chenys@163.com");
		user.setUserPwd("123456");
		BaseUser byUser = dao.getByUser(user );
		System.out.println("========================="+byUser);
	}
}
