package com.stocks.test.service;

import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stocks.SpringBootApplication;
import com.stocks.service.PlateListService;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月22日 上午10:49:10 
  * @version：   1.0.0
  * @describe:    
  */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SpringBootApplication.class)
public class PlateListServiceTest {
	@Autowired
	private PlateListService pls;
	
	@Test
	public void test(){
		Map<String, Object> listByPlate = pls.getListByPlate("2ce83aa5-8ca7-11e8-af3f-88c234bb101e");
		Set<String> keySet = listByPlate.keySet();
		for (String string : keySet) {
			System.out.println(listByPlate.get(string));
		}
	}
}
