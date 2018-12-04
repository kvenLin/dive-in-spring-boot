package com.imooc.demo.service;

/**
 * @Author: clf
 * @Date: 18-12-3
 * @Description:
 * 计算服务
 */
public interface CalculateService {
    /**
     * 多个整数sum求和
     * @param values
     * @return
     */
    Integer sum(Integer... values);
}
