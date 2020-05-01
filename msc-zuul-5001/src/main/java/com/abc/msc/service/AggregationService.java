package com.abc.msc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.msc.entity.Dept;
import com.abc.msc.entity.Emp;

import rx.Observable;

@Service
public class AggregationService {

	@Autowired
	private EmpClientService empClientService;
	@Autowired
	private DeptClientService deptClientService;

	public Observable<Emp> getEmpById(Long id) {
		return Observable.create(observer -> {
			Emp emp = empClientService.get(id);
			observer.onNext(emp);
			observer.onCompleted();
		});
	}
	
	public Observable<Dept> getDeptById(Long id) {
		return Observable.create(observer -> {
			Dept dept = deptClientService.get(id);
			observer.onNext(dept);
			observer.onCompleted();
		});
	}

}
