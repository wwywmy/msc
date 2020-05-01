package com.abc.msc.service;

import java.util.List;

import com.abc.msc.entity.Dept;

public interface DeptService {
	boolean add(Dept dept);
	Dept get(Long id);
	List<Dept> list();
}
