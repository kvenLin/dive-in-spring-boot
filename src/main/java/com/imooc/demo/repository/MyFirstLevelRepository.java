package com.imooc.demo.repository;

import com.imooc.demo.annotation.FirstLevelRepository;
import org.springframework.stereotype.Component;

/**
 * @Author: clf
 * @Date: 18-12-2
 * @Description:
 */
@FirstLevelRepository(value = "myFirstLevelRepository")//Bean的名称
//@Component(value = "myFirstLevelRepository")
public class MyFirstLevelRepository {

}
