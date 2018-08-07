package com.stocks.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocks.dao.BasePlateDao;
import com.stocks.entity.BasePlate;
import com.stocks.service.BasePlateService;

/** @author:  v_chenyongshuai@:
  * @date:  2018年8月5日 上午10:23:01 
  * @version：   1.0.0
  * @describe:    
  */
@Service
public class BasePlateServiceImpl implements BasePlateService{

	@Autowired
	private BasePlateDao bpd;
	
	@Override
	public Map<String, Object> getPlateList(String userNo) {
		Map<String,Object>map = new HashMap<String, Object>();
		List<BasePlate> plateList = bpd.getByUser(userNo);
		int count = bpd.getCount(userNo);
		map.put("data", plateList);
		map.put("count", count);
		map.put("code", "0");
		return map;
	}

	@Override
	public boolean addPlate(BasePlate plate) {
		int addPlate = bpd.addPlate(plate);
		if(addPlate==1){
			return true;
		}
		return false;
	}

	@Override
	public boolean editPlate(BasePlate plate) {
		int editPlate = bpd.editPlate(plate);
		if(editPlate==1){
			return true;
		}
		return false;
	}

	@Override
	public boolean delPlate(String[] buidList) {
		int delPlate = bpd.delPlate(buidList);
		if(delPlate>=1){
			return true;
		}
		return false;
	}

}
