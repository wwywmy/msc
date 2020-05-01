package com.abc.msc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abc.msc.entity.Dept;
import com.abc.msc.service.DeptClientService;

@RestController
@RequestMapping("/consumer/dept")
public class DeptConsumerController {

	@Autowired
	private DeptClientService deptClientService;

	@RequestMapping(value = "/add")
	public boolean add(Dept dept) {
		return deptClientService.add(dept);
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id) {
		return deptClientService.get(id);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Dept> list() {
		return deptClientService.list();
	}

}
