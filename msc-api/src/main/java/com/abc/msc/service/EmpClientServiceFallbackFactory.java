package com.abc.msc.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.abc.msc.entity.Emp;

import feign.hystrix.FallbackFactory;

@Component
public class EmpClientServiceFallbackFactory implements FallbackFactory<EmpClientService>{

	@Override
	public EmpClientService create(Throwable cause) {
		return new EmpClientService() {

			@Override
			public boolean add(Emp emp) {
				return false;
			}

			@Override
			public Emp get(Long id) {
				Emp emp = new Emp();
				emp.setEmpNo(id);
				emp.setEmpName("No Emp");

				return emp;
			}

			@Override
			public List<Emp> list() {
				return null;
			}
			
		};
	}


}
