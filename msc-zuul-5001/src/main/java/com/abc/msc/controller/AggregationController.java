package com.abc.msc.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.abc.msc.service.AggregationService;
import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;
import rx.Observable;
import rx.Observer;

@RestController
@Slf4j
public class AggregationController {

	@Autowired
	private AggregationService aggregationService;

	@GetMapping("/aggregate/{id}")
	public DeferredResult<HashMap<String, Object>> aggregate(@PathVariable Long id) {
		Observable<HashMap<String, Object>> details = this.aggregateObservable(id);
		return this.toDeferredResult(details);
	}

	public Observable<HashMap<String, Object>> aggregateObservable(Long id) {
		return Observable.zip(//
				aggregationService.getEmpById(id), //
				aggregationService.getDeptById(id), //
				(emp, dept) -> {
					HashMap<String, Object> map = Maps.newHashMap();
					map.put("emp", emp);
					map.put("dept", dept);
					return map;
				});
	}

	public DeferredResult<HashMap<String, Object>> toDeferredResult(Observable<HashMap<String, Object>> details) {
		DeferredResult<HashMap<String, Object>> result = new DeferredResult<>();

		// 订阅
		details.subscribe(new Observer<HashMap<String, Object>>() {

			@Override
			public void onCompleted() {
				log.info("onCompleted");
			}

			@Override
			public void onError(Throwable e) {
				log.error("onError", e);

			}

			@Override
			public void onNext(HashMap<String, Object> t) {
				result.setResult(t);
			}

		});

		return result;
	}
}
