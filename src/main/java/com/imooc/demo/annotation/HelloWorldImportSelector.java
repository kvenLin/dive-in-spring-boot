package com.imooc.demo.annotation;

import com.imooc.demo.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: clf
 * @Date: 18-12-2
 * @Description:
 * HelloWorld {@link ImportSelector} 实现
 */
public class HelloWorldImportSelector implements ImportSelector{

    /**
     * 使用Selector来进行导入,
     * 相对于直接使用@Import导入HelloWorldConfiguration类中的Bean,
     * 这种方法更有弹性,
     * 能够在方法中进行其他的逻辑操作
     * @param annotationMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{HelloWorldConfiguration.class.getName()};
    }
}
