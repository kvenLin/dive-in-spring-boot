package com.imooc.springapplication.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @Author: clf
 * @Date: 18-12-9
 * @Description:
 * HelloWorld监听ContextRefreshedEvent事件
 */
@Order(Ordered.HIGHEST_PRECEDENCE)//最高优先级进行加载
public class HelloWorldApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("HelloWorld : " + event.getApplicationContext().getId()
                + " , timestamp : " + event.getTimestamp());
    }
}
