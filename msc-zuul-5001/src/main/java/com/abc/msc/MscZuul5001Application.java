package com.abc.msc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableFeignClients(basePackages= {"com.abc.msc"})
@ComponentScan(basePackages= {"com.abc.msc"})
public class MscZuul5001Application {

    public static void main(String[] args) {
        SpringApplication.run(MscZuul5001Application.class, args);
    }

}
