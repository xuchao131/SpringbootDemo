package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuchao
 * 2018年9月26日
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
	
	@Autowired
	private DemoDao demoDao;
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;
	
	@RequestMapping("/redisTest")
	public Object redisTest(){
		redisTemplate.opsForValue().set("name", "张三");
		redisTemplate.opsForValue().set("age", 35);
		redisTemplate.opsForValue().set("sex", "男");
		redisTemplate.opsForValue().set("address", "昌平");
		redisTemplate.opsForValue().set("tel", 123456);
		return redisTemplate.opsForValue().get("name");
	}
	
	@RequestMapping("/index")
	public Map<String,Object> test(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "李四");
		map.put("age", "24");
		map.put("address", "昌平区");
		return map;
	}
	
	@RequestMapping("/queryList")
	public List<DemoUser> queryList(){
		List<DemoUser> list = demoDao.findAll();
		return list;
	}
	
	@RequestMapping("/insertUser")
	public Integer insertUser(DemoUser demoUser){
		demoUser.setId("1");
		demoUser.setName("张三");
		demoUser.setAge(30);
		demoUser.setSex("女");
		demoDao.save(demoUser);
		return 1;
	}
	
	@RequestMapping("/queryByName")
	public List<DemoUser> queryByName(String name){
		name = "李四";
		List<DemoUser> list = demoDao.findByName(name);
		return list;
	}
	
	@RequestMapping("/pageList")
	public Page<DemoUser> pageList(){
		Sort.Order order = new Sort.Order(Sort.Direction.DESC,"age");
		Sort sort = new Sort(order);
		PageRequest pr = new PageRequest(0, 5, sort);
		Page<DemoUser> page = demoDao.findAll(pr);
		System.out.println("当前页是"+(page.getNumber()+1));
		System.out.println("总页数是"+page.getTotalPages());
		System.out.println("当前页记录数是"+page.getNumberOfElements());
		System.out.println("总记录数是"+page.getTotalElements());
		return page;
	}
}
