package com.stocks.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocks.dao.PlateListDao;
import com.stocks.dao.StockDao;
import com.stocks.dao.StockDayDao;
import com.stocks.entity.PlateList;
import com.stocks.service.PlateListService;
import com.stocks.vo.StockDayVO;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月21日 下午4:29:08 
  * @version：   1.0.0
  * @describe:    
  */
@Service
public class PlateListServiceImpl implements PlateListService{
	@Autowired
	private PlateListDao pld;
	
	@Autowired
	private StockDayDao sdd;
	
	@Autowired
	private StockDao sd;
	
	
	@Override
	public Map<String,Object> getListByPlate(String plateBuid) {
		Map<String,Object>map = new HashMap<String, Object>();
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date dateNow = new Date();
		while(true){
			String dateStrNow = sdf.format(dateNow);
			String doGet = HttpUtils.doGet(WorkDay.isWorkDayURL+dateStrNow);
			JSONObject parseObject = JSON.parseObject(doGet);
			Integer isWorkDay = parseObject.getInteger("data");
			Integer i = 0;
			if(i.equals(isWorkDay)){
				break;
			}else{
				try {
					Calendar c = Calendar.getInstance();
					Date parse = sdf.parse(dateStrNow);
					c.setTime(parse);
					c.add(Calendar.DAY_OF_MONTH,-1);
					dateNow = c.getTime();
				} catch (ParseException e) {
					map.put("code", "1");
					map.put("msg", "数据加载状态异常");
				}
			}
		}
		if("1".equals(map.get("code"))){
			return map;
		}
		sdf = new SimpleDateFormat("yyyy-MM-dd");*/
		List<PlateList> plateList = pld.getPlateList(plateBuid);
		List<StockDayVO> stockList = new ArrayList<StockDayVO>();
		for (PlateList list : plateList) {
			String stockBuid = list.getStockBuid();
			StockDayVO byBuidNow = sdd.getByBuidLast(stockBuid);
			stockList.add(byBuidNow);
		}
		map.put("data", stockList);
		map.put("count", pld.getPlateListCount(plateBuid));
		map.put("code", "0");
		return map;
	}
}
