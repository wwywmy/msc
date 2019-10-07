package com.abc.msc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class MscEureka7003Application {

    public static void main(String[] args) {
        SpringApplication.run(MscEureka7003Application.class, args);
    }

}
