package com.abc.msc.service;

import java.util.List;

import com.abc.msc.entity.Emp;

public interface EmpService {
	boolean add(Emp dept);
	Emp get(Long id);
	List<Emp> list();
}
