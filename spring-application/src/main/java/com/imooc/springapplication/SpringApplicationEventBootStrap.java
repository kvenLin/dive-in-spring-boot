package com.imooc.springapplication;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: clf
 * @Date: 18-12-9
 * @Description:
 * Spring的事件引导类
 */
public class SpringApplicationEventBootStrap {
    public static void main(String[] args) {
        //创建上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册应用事件监听器
        context.addApplicationListener(event -> {
            System.out.println("监听事件 : " + event);
        });
        //启动上下文
        context.refresh();
        //发布事件
        context.publishEvent("HelloWorld");
        context.publishEvent(new ApplicationEvent("HelloWorld") {
        });
        //关闭上下文
        context.close();
    }

}
