package com.stocks.service;

import java.util.List;


import com.stocks.entity.BaseResource;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月24日 下午1:41:16 
  * @version：   1.0.0
  * @describe:    
  */
public interface BaseResourceService {
	
	/**
	 * The initial version has no permission Settings
	 * @param buid 
	 * @return List<BaseResource>
	 */
	List<BaseResource> getBaseResource();
}
