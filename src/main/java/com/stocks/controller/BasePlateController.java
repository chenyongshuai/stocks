package com.stocks.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stocks.entity.BasePlate;
import com.stocks.entity.BaseUser;
import com.stocks.service.BasePlateService;

/** @author:  v_chenyongshuai@:
  * @date:  2018年8月5日 上午10:26:15 
  * @version：   1.0.0
  * @describe:    
  */
@Controller
@RequestMapping("/plate")
public class BasePlateController {
	
	@Autowired
	private BasePlateService bps;
	
	@RequestMapping("/getPlateList")
	@ResponseBody
	public Map<String, Object> getPlateList(HttpSession session){
		BaseUser user = (BaseUser) session.getAttribute("user");
		return bps.getPlateList("0030e80c-8c04-11e8-af3f-88c234bb101e");
	}
	
	@RequestMapping("/addPlate")
	@ResponseBody
	public boolean addPlate(BasePlate plate, HttpSession session){
		BaseUser user = (BaseUser) session.getAttribute("user");
		plate.setUserNo("0030e80c-8c04-11e8-af3f-88c234bb101e");
		return bps.addPlate(plate);
	}
	
	@RequestMapping("/editPlate")
	@ResponseBody
	public boolean editPlate(BasePlate plate){
		return bps.editPlate(plate);
	}
	
	@RequestMapping("/delPlate")
	@ResponseBody
	public boolean editPlate(String [] buidList){
		return bps.delPlate(buidList);
	}
	
}
