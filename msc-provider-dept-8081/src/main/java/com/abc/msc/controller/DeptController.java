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

import com.abc.msc.entity.Dept;
import com.abc.msc.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/dept")
@Slf4j
public class DeptController {

	@Autowired
	private DeptService deptService;

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		return deptService.add(dept);
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id) {
		return deptService.get(id);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Dept> list() {
		List<Dept> deptList = deptService.list();
		return deptList;
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
