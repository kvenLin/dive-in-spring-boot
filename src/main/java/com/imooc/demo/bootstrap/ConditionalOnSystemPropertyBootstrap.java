package com.imooc.demo.bootstrap;

import com.imooc.demo.condition.ConditionalOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import sun.swing.StringUIClientPropertyKey;

/**
 * @Author: clf
 * @Date: 18-12-4
 * @Description:'
 * 系统属性条件引导类
 */
public class ConditionalOnSystemPropertyBootstrap {

    @Bean
    @ConditionalOnSystemProperty(name = "user.name",value = "hk")//即启动类中value相同时进行导入这个bean
    public String helloWorld(){
        return "Hello World ,hk!";
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalOnSystemPropertyBootstrap.class)
                .web(WebApplicationType.NONE)//非web类型
                .run(args);
        //通过名称获得helloWorld Bean
        String helloWorld = context.getBean("helloWorld",String.class);
        System.out.println("helloWorld Bean : " + helloWorld);
        //关闭上下文
        context.close();
    }
}
