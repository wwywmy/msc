package com.abc.msc.cfgbean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class ConfigBean {
	
//	@Bean
//	public UserService getUserService() {
//		return UserServiceImpl();
//	}
//applicationContext.xml = @Configuration
//<bean id="userService" class="com.abc.msc.service.impl.UserServiceImpl">	
	
	@Bean
	@LoadBalanced //Ribbon
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public IRule myRule() {
		//return new RoundRobinRule();
		return new RandomRule();
	}
	
}
