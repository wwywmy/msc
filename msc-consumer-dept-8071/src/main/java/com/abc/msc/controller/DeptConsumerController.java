package com.abc.msc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.abc.msc.entity.Dept;

@RestController
@RequestMapping("/consumer/dept")
public class DeptConsumerController {

	//private static final String REST_URL_PREFIX = "http://localhost:8081";
	private static final String REST_URL_PREFIX = "http://MSC-DEPT";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/add")
	public boolean add(Dept dept) {
		return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept, Boolean.class);
	}
	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id) {
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Dept> list() {
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
	}
	
	@RequestMapping(value = "/discovery", method = RequestMethod.GET)
	public Object discovery() {
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery",Object.class);
	}
	
	
}
