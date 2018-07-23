package com.stocks.test.dao;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.stocks.SpringBootApplication;
import com.stocks.dao.StockDao;
import com.stocks.entity.Stock;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月19日 下午9:21:06 
  * @version：   1.0.0
  * @describe:    
  */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SpringBootApplication.class)
@WebAppConfiguration
public class StockDaoTest {
	@Autowired
	private StockDao dao;
	@Test
	public void testAdd(){
		Stock stock = new Stock(UUID.randomUUID().toString(),"600740","山西焦化",null,"sh",null,"chenys",null,"chenys");
		int addStock = dao.addStock(stock );
		System.out.println(addStock);
	}
}
