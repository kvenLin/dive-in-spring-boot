package com.imooc.springapplication.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @Author: clf
 * @Date: 18-12-5
 * @Description:
 */
@Order(Ordered.HIGHEST_PRECEDENCE)//设置为最高优先级
public class HelloWorldApplicationContextInitializer<C extends ConfigurableApplicationContext>
        implements ApplicationContextInitializer<C> {

    @Override
    public void initialize(C applicationContext) {
        System.out.println("ConfigurableApplicationContext.id : " + applicationContext.getId());
    }
}
