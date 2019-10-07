package com.abc.msc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MscConsumerDept8071Application {
	  public static void main(String[] args) {
	        SpringApplication.run(MscConsumerDept8071Application.class, args);
	    }

}
