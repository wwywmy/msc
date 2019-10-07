package com.abc.msc.mapper.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.abc.msc.entity.Dept;
import com.abc.msc.mapper.DeptMapper;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DeptTest {
	@Resource
	private DeptMapper deptMapper;
	
	@Test
	public void selectList() {
		List<Dept> deptList = deptMapper.selectList(null);
		deptList.forEach(d->{log.info(d.toString());});
	}
}
