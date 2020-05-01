package com.abc.msc.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.abc.msc.entity.Dept;

import feign.hystrix.FallbackFactory;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable cause) {
		return new DeptClientService() {

			@Override
			public boolean add(Dept dept) {
				return false;
			}

			@Override
			public Dept get(Long id) {
				Dept dept = new Dept();
				dept.setDeptNo(id);
				dept.setDeptName("No Data");
				dept.setDbSource("No DB source");

				return dept;
			}

			@Override
			public List<Dept> list() {
				return null;
			}
			
		};
	}


}
