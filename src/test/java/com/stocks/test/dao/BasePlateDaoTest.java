package com.stocks.test.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stocks.SpringBootApplication;
import com.stocks.dao.BasePlateDao;
import com.stocks.entity.BasePlate;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月21日 下午2:09:45 
  * @version：   1.0.0
  * @describe:    
  */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SpringBootApplication.class)
public class BasePlateDaoTest {
	@Autowired
	private BasePlateDao bpd;
	@Test
	public void test(){
		List<BasePlate> byUser = bpd.getByUser("0030e80c-8c04-11e8-af3f-88c234bb101e", null);
		System.out.println();
	}
}
