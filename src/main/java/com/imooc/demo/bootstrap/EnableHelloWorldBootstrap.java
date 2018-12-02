package com.imooc.demo.bootstrap;

import com.imooc.demo.annotation.EnableHelloWorld;
import com.imooc.demo.configuration.HelloWorldConfiguration;
import com.imooc.demo.repository.MyFirstLevelRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: clf
 * @Date: 18-12-2
 * @Description:
 */
@EnableHelloWorld
public class EnableHelloWorldBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloWorldBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        //测试@EableHelloWorld
        String helloWorld = context.getBean("helloWorld",String.class);
        System.out.println("HelloWorld Bean : " + helloWorld);

        //关闭上下文
        context.close();
    }
}
