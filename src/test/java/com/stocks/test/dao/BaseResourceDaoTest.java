package com.stocks.test.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stocks.SpringBootApplication;
import com.stocks.dao.BaseResourceDao;
import com.stocks.entity.BaseResource;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月24日 下午1:38:04 
  * @version：   1.0.0
  * @describe:    
  */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SpringBootApplication.class)
public class BaseResourceDaoTest {
	
	@Autowired
	private BaseResourceDao dao;
	
	@Test
	public void test(){
		List<BaseResource> baseResource = dao.getBaseResource(null);
		for (BaseResource baseResource2 : baseResource) {
			System.out.println(baseResource2);
		}
	}
	
}
