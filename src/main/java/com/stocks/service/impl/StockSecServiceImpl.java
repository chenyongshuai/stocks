package com.stocks.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocks.dao.StockSecDao;
import com.stocks.entity.StockSec;
import com.stocks.service.StockSecService;



/** @author:  v_chenyongshuai@:
  * @date:  2018��7��15�� ����9:00:08 
  * @version��   1.0.0
  * @describe:    
  */
@Service
public class StockSecServiceImpl implements StockSecService {

	@Autowired
	private StockSecDao dao;
	
	public int addStockSec(StockSec sds) {
		return dao.addStockSec(sds);
	}

}
