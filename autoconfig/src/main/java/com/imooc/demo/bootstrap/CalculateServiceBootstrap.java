package com.imooc.demo.bootstrap;

import com.imooc.demo.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: clf
 * @Date: 18-12-3
 * @Description:
 * 引导类
 */
@SpringBootApplication(scanBasePackages = "com.imooc.demo.service")
public class CalculateServiceBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(CalculateServiceBootstrap.class)
                .web(WebApplicationType.NONE)//非web类型
                .profiles("Java7")//指定Profile进行条件配置Bean
                .run(args);

        CalculateService calculateService = context.getBean(CalculateService.class);
        System.out.println("CalculateService.sum(1... 10) = "
                + calculateService.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        //关闭上下文
        context.close();
    }
}
