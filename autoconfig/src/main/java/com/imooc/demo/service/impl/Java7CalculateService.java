package com.imooc.demo.service.impl;

import com.imooc.demo.service.CalculateService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @Author: clf
 * @Date: 18-12-3
 * @Description:
 * Java7循环实现CalculateService接口
 */
@Profile("Java7")//条件为Java7的时候进行激活
@Service
public class Java7CalculateService implements CalculateService {
    @Override
    public Integer sum(Integer... values) {
        System.out.println("Using Java7 to Calculate:");
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum;
    }
}
