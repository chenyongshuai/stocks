package com.stocks.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.stocks.entity.StockDay;
import com.stocks.service.StockDayService;

/** @author:  v_chenyongshuai@:
  * @date:  2018��7��16�� ����10:48:39 
  * @version��   1.0.0
  * @describe:    
  */
@Controller
@RequestMapping("/day")
public class StockDayController {
	
	@Autowired
	private StockDayService sdds;
	
	@RequestMapping("/getByBuid/{buid}")
	public @ResponseBody String getByBuid(HttpServletRequest request,@PathVariable(value="buid") String buid){
		
		/*String basePath = request.getServletContext().getRealPath("/");
		String url = request.getScheme()+"://"+ request.getServerName()+request.getRequestURI()+"?"+request.getQueryString();
		System.out.println("获取全路径（协议类型：//域名/项目名/命名空间/action名称?其他参数）url="+url);
		String url2=request.getScheme()+"://"+ request.getServerName();//+request.getRequestURI();
		System.out.println("协议名：//域名="+url2);
		String path = this.getClass().getResource("/").getPath();//获取类的当前目录
		System.out.println(realPath);
		System.out.println(path);
		System.out.println("获取项目名="+request.getContextPath());
		System.out.println("获取参数="+request.getQueryString());
		System.out.println("获取全路径="+request.getRequestURL());*/
		
		List<StockDay> stockDay = sdds.getByBuid(buid);
		ArrayList<String[]>list = new ArrayList<String[]>();
		for (StockDay s : stockDay) {
			String[]arr = new String[6];
			arr[0] = s.getDetailDay();
			arr[1] = s.getOpenPrice().toString();
			arr[2] = s.getClosePrice().toString();
			arr[3] = s.getLowPrice().toString();
			arr[4] = s.getTopPrice().toString();
			arr[5] = s.getDealCount().toString();
			list.add(arr);
		}
		String jsonString = JSON.toJSONString(list);
		try {
			String realPath = request.getSession().getServletContext().getRealPath("/");//获取web项目的路径
			//System.out.println(realPath);
			File file = new File(realPath+"data\\"+buid+".json");
			if(!file.exists()){
				File parentFile = file.getParentFile();
				parentFile.mkdirs();
				file.createNewFile();
			}
			IOUtils.write(jsonString, new FileOutputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "true";
	}
}
