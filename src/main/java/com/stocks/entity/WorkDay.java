package com.stocks.entity;

import java.io.Serializable;

/** @author:  v_chenyongshuai@:
  * @data:  2018��7��16�� ����10:22:18 
  * @version��   1.0.0
  * @describe:    
  */
public class WorkDay implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8562417000825068706L;
	/**
	 * 0 workday
	 * 1 freeday
	 */
	public static final String isWorkDayURL = "http://api.goseek.cn/Tools/holiday?date=";
	
	private String code;
	private String data;
	public WorkDay() {
		super();
		
	}
	public WorkDay(String code, String data) {
		super();
		this.code = code;
		this.data = data;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "WorkDay [code=" + code + ", data=" + data + "]";
	}
	
}
