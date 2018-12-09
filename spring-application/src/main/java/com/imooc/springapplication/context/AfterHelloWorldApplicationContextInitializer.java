package com.imooc.springapplication.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

/**
 * @Author: clf
 * @Date: 18-12-5
 * @Description:
 */
public class AfterHelloWorldApplicationContextInitializer
        implements ApplicationContextInitializer,Ordered {//使用@Order和继承Ordered效果相同

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("After application.id : " + applicationContext.getId());
    }

    @Override
    public int getOrder() {
        //指定为最低优先级
        return Ordered.LOWEST_PRECEDENCE;
    }
}
