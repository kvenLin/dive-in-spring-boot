package com.imooc.springapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;


public class SpringApplicationBootstrap {
    public static void main(String[] args) {
        //在创建SpringBoot是配置源Bean只需要对添加@SpringBootApplication的类进行添加就可以进行启动
//        SpringApplication.run(ApplicationConfiguration.class, args);
        Set<String> sources = new HashSet<>();
        //sources配置Class的名称
        sources.add(ApplicationConfiguration.class.getName());
        SpringApplication application = new SpringApplication();
        application.setSources(sources);
//        application.setWebApplicationType(WebApplicationType.NONE);
        ConfigurableApplicationContext context = application.run(args);
        Object bean = context.getBean(ApplicationConfiguration.class);
        System.out.println("Bean: " + bean);

    }

    @SpringBootApplication
    public static class ApplicationConfiguration{

    }
}
