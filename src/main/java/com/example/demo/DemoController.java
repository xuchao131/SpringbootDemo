package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuchao
 * 2018年9月26日
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
	
	@RequestMapping("/index")
	public Map<String,Object> test(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "李四");
		return map;
	}
}
