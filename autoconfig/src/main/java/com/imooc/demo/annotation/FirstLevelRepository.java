package com.imooc.demo.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * @Author: clf
 * @Date: 18-12-2
 * @Description:
 * 一级 {@link Repository @Repository}
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repository
public @interface FirstLevelRepository {
    String value() default "";
}