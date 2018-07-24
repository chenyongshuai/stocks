package com.stocks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stocks.entity.BaseResource;
import com.stocks.service.BaseResourceService;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月24日 下午1:43:31 
  * @version：   1.0.0
  * @describe:    
  */
@RestController
@RequestMapping("/res")
public class BaseResoruceController {
	
	@Autowired
	private BaseResourceService brs;
	
	@RequestMapping("/init")
	@ResponseBody
	public List<BaseResource> getSide(){
		return brs.getBaseResource();
	}
	
}
