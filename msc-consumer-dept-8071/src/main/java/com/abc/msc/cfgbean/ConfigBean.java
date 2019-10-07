package com.abc.msc.cfgbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
	
//	@Bean
//	public UserService getUserService() {
//		return UserServiceImpl();
//	}
//applicationContext.xml = @Configuration
//<bean id="userService" class="com.abc.msc.service.impl.UserServiceImpl">	
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
}
