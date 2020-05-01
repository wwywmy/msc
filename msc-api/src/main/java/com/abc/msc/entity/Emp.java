package com.abc.msc.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Emp implements Serializable{
	@TableId(value = "emp_no", type = IdType.AUTO)
	private Long empNo;
	private String empName;
	private Long deptNo;
	private String empDesc;
}
