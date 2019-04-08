package com.stocks.entity;
/** @author:  v_chenyongshuai@:
  * @date:  2018��7��16�� ����8:56:06 
  * @version��   1.0.0
  * @describe:    
  */
public class SohuStock {
	//历史数据
	public static final String sohuURL = "http://q.stock.sohu.com/hisHq?code=cn_(1)&start=(2)&end=(3)&stat=1&order=D&period=d&callback=historySearchHandler&rt=jsonp";

	//实时数据
	public static final String nowDataURL = "http://hq.sinajs.cn/list=(1)(2)";
	
	//周线数据
	public static final String weekURL = "http://q.stock.sohu.com/hisHq?code=cn_(1)&start=(2)&end=(3)&stat=1&order=D&period=w&callback=historySearchHandler&rt=jsonp";
	
}
