package com.imooc.demo.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * @Author: clf
 * @Date: 18-12-2
 * @Description:
 * 二级 {@link Repository @Repository}
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@FirstLevelRepository
public @interface SecondLevelRepository {
    String value() default "";
}