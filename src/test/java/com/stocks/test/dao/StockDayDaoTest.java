package com.stocks.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stocks.SpringBootApplication;
import com.stocks.dao.StockDayDao;
import com.stocks.vo.StockDayVO;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月21日 下午10:30:17 
  * @version：   1.0.0
  * @describe:    
  */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SpringBootApplication.class)
public class StockDayDaoTest {
	@Autowired
	private StockDayDao sdd;
	
	@Test
	public void test(){
		StockDayVO stockDayVO = sdd.getByBuidLast("1014fd95-194c-4382-82c4-5d3dbb38b711");
		System.out.println(stockDayVO);
	}
}
