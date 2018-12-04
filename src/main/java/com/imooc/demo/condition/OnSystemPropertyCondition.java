package com.imooc.demo.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @Author: clf
 * @Date: 18-12-4
 * @Description:
 * 系统属性条件判断
 */
public class OnSystemPropertyCondition implements Condition {
    /**
     *
     * @param context
     * @param metadata 源信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //获取@ConditionalOnSystemProperty中所有属性的值
        Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());

        String propertyName = (String) attributes.get("name");
        String propertyValue = (String) attributes.get("value");

        //获取系统中的user.name的值
        String javaPropertyValue = System.getProperty(propertyName);
        //判断是否对应的值是否相等
        return propertyValue.equals(javaPropertyValue);
    }
}
