package com.abc.msc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.msc.entity.Dept;
import com.abc.msc.mapper.DeptMapper;
import com.abc.msc.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	private DeptMapper deptMapper;

	@Override
	public boolean add(Dept dept) {
		int count = deptMapper.insert(dept);
		return (count>0);
	}

	@Override
	public Dept get(Long id) {
		Dept dept = deptMapper.selectById(id);
		return dept;
	}

	@Override
	public List<Dept> list() {
		List<Dept> deptList = deptMapper.selectList(null);
		return deptList;
	}

}
