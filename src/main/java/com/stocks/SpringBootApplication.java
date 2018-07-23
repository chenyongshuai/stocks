package com.stocks;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

/** @author:  v_chenyongshuai@:
  * @date:  2018年7月19日 下午4:22:27 
  * @version：   1.0.0
  * @describe: 启动类
  */

@org.springframework.boot.autoconfigure.SpringBootApplication
@MapperScan("com.stocks.dao")
public class SpringBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);
	}
}
