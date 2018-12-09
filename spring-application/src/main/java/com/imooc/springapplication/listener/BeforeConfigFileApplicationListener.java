package com.imooc.springapplication.listener;

import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.lang.Nullable;

/**
 * @Author: clf
 * @Date: 18-12-9
 * @Description:
 * Before {@link ConfigFileApplicationListener} 实现
 */
public class BeforeConfigFileApplicationListener implements SmartApplicationListener,Ordered {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType) || ApplicationPreparedEvent.class.isAssignableFrom(eventType);
    }

    @Override
    public boolean supportsSourceType(@Nullable Class<?> sourceType) {
        return true;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            ApplicationEnvironmentPreparedEvent papreEvent = (ApplicationEnvironmentPreparedEvent) event;
            Environment environment = papreEvent.getEnvironment();
            System.out.println("environment.getProperties(\"name\") : " + environment.getProperty("name"));
        }

        if (event instanceof ApplicationPreparedEvent) {
        }

    }

    @Override
    public int getOrder() {
        //比ConfigFileApplicationListener加载的优先级更高
        return ConfigFileApplicationListener.DEFAULT_ORDER + 1;
    }
}
