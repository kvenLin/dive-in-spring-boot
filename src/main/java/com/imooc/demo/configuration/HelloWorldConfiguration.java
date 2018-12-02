package com.imooc.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: clf
 * @Date: 18-12-2
 * @Description:
 * HelloWorld的自动化装配
 */
@Configuration
public class HelloWorldConfiguration {

    @Bean(name = "helloWorld")
    public String helloWorld() { //方法名即为Bean名称
        return "Hello World 2018";
    }
}
