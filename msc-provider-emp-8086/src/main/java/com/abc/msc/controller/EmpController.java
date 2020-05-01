package com.abc.msc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abc.msc.entity.Emp;
import com.abc.msc.service.EmpService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/emp")
@Slf4j
public class EmpController {

	@Autowired
	private EmpService empService;

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Emp emp) {
		return empService.add(emp);
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Emp get(@PathVariable("id") Long id) {
		return empService.get(id);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Emp> list() {
		List<Emp> empList = empService.list();
		return empList;
	}

	@RequestMapping(value = "/discovery", method = RequestMethod.GET)
	public Object discovery() {
		List<String> list = discoveryClient.getServices();
		list.forEach(s -> log.info(s));

		List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("MSC-DEPT");

		serviceInstanceList.forEach(s -> {
			log.info(s.getServiceId() + "\t" + s.getHost() + "\t" + s.getPort() + "\t" + s.getUri());
		});

		return discoveryClient;
	}
}
