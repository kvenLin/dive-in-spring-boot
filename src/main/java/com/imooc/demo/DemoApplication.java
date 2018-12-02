package com.imooc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.imooc.demo.web.servlet")//注册servlet,在对应的包中进行寻找实现的servlet
public class DemoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
        //与上面等价的写法
        new SpringApplicationBuilder(DemoApplication.class)
                .run(args);
    }
}
