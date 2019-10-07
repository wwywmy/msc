package com.abc.msc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class MscProviderDept8081Application {

    public static void main(String[] args) {
        SpringApplication.run(MscProviderDept8081Application.class, args);
    }

}
