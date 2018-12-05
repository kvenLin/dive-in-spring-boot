package com.imooc.demo.configuration;

import com.imooc.demo.annotation.EnableHelloWorld;
import com.imooc.demo.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: clf
 * @Date: 18-12-2
 * @Description: HelloWorld的自动化装配
 */
@Configuration// Spring 模式注解
@EnableHelloWorld// Spring @Enable 模块装配
@ConditionalOnSystemProperty(name = "user.name", value = "hk")// 条件装配
public class HelloWorldAutoConfiguration {

}
