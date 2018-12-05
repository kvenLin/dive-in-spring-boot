package com.imooc.demo.service.impl;

import com.imooc.demo.service.CalculateService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * @Author: clf
 * @Date: 18-12-3
 * @Description:
 * Java8 Lambda实现CalculateService接口
 */
@Profile("Java8")//条件为Java7的时候进行激活
@Service
public class Java8CalculateService implements CalculateService {
    @Override
    public Integer sum(Integer... values) {
        System.out.println("Using Java8 to Calculate:");
        int sum = Stream.of(values).reduce(0,Integer::sum);
        return sum;
    }

}
