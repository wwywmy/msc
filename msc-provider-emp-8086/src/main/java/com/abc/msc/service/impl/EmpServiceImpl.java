package com.abc.msc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.msc.entity.Emp;
import com.abc.msc.mapper.EmpMapper;
import com.abc.msc.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpMapper empMapper;

	@Override
	public boolean add(Emp emp) {
		int count = empMapper.insert(emp);
		return (count>0);
	}

	@Override
	public Emp get(Long id) {
		Emp emp = empMapper.selectById(id);
		return emp;
	}

	@Override
	public List<Emp> list() {
		List<Emp> empList = empMapper.selectList(null);
		return empList;
	}

}
