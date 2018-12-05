package com.imooc.demo.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

;

/**
 * @Author: clf
 * @Date: 18-12-4
 * @Description:
 * Java系统属性条件判断
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {
    /**
     * Java系统属性的名称
     * @return
     */
    String name();

    /**
     * Java系统属性值
     * @return
     */
    String value();
}
