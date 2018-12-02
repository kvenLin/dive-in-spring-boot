package com.imooc.demo.annotation;

import com.imooc.demo.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author: clf
 * @Date: 18-12-2
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
//@Import(HelloWorldConfiguration.class)
@Import(HelloWorldImportSelector.class)//使用selector实现的接口进行导入需要的bean
public @interface EnableHelloWorld {
}
