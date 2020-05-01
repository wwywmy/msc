package com.abc.msc.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abc.msc.entity.Emp;

@FeignClient(value = "MSC-EMP",fallbackFactory = EmpClientServiceFallbackFactory.class)
public interface EmpClientService {

	@RequestMapping(value = "/emp/add", method = RequestMethod.POST)
	public boolean add(Emp emp);

	@RequestMapping(value = "/emp/get/{id}", method = RequestMethod.GET)
	public Emp get(@PathVariable("id") Long id);

	@RequestMapping(value = "/emp/list", method = RequestMethod.GET)
	public List<Emp> list();
}
