package com.abc.msc.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.abc.msc.mapper")
public class MybatisPlusConfig {

}
