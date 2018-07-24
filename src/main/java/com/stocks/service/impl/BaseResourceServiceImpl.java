package com.stocks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocks.dao.BaseResourceDao;
import com.stocks.entity.BaseResource;
import com.stocks.service.BaseResourceService;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月24日 下午1:41:46 
  * @version：   1.0.0
  * @describe:    
  */
@Service
public class BaseResourceServiceImpl implements BaseResourceService {

	@Autowired
	private BaseResourceDao brd;
	
	@Override
	public List<BaseResource> getBaseResource() {
		List<BaseResource> baseResource = brd.getBaseResource(null);
		for (BaseResource resource : baseResource) {
			String buid = resource.getBuid();
			List<BaseResource> resourceList = brd.getBaseResource(buid);
		}
		return baseResource;
	}

}
