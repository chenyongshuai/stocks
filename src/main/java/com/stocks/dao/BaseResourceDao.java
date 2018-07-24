package com.stocks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.stocks.entity.BaseResource;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月24日 下午1:32:31 
  * @version：   1.0.0
  * @describe:    
  */
public interface BaseResourceDao {
	
	/**
	 * The initial version has no permission Settings
	 * @return List<BaseResource>
	 */
	@Select("select buid,show_seq,res_cn_title,res_eng_title,res_parent_id,res_level,res_href,res_icon,res_content from base_resource where res_type='side' and res_parent_id=#{resParentId}")
	List<BaseResource> getBaseResource(String resParentId);
	
	
}
