package com.imooc.demo.bootstrap;

import com.imooc.demo.annotation.EnableHelloWorld;
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
                .web(WebApplicationType.NONE)//非web类型
                .run(args);

        //测试@EableHelloWorld
        String helloWorld = context.getBean("helloWorld",String.class);
        System.out.println("HelloWorld Bean : " + helloWorld);

        //关闭上下文
        context.close();
    }
}
