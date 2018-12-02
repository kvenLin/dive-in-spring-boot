package com.imooc.demo.bootstrap;

import com.imooc.demo.repository.MyFirstLevelRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: clf
 * @Date: 18-12-2
 * @Description:
 */
@ComponentScan(basePackages = "com.imooc.demo.repository.MyFirstLevelRepository")
public class RepositoryBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(MyFirstLevelRepository.class)
                .web(WebApplicationType.NONE)
                .run(args);

        //检测myFirstLevelRepository这个Bean是否存在
        MyFirstLevelRepository repository = context.getBean("myFirstLevelRepository",MyFirstLevelRepository.class);
        System.out.println("检测myFirstLevelRepository: " + repository.toString());


        //关闭上下文
        context.close();
    }
}
