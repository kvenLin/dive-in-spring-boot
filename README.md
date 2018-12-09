# dive-in-spring-boot
SpringBoot深度学习

## Web 应用
### Servlet组件
* Servlet
    * 实现
        * 添加@WebServlet注解
        * 继承HttpServlet
        * 注册
    * url的映射
        * @WebServlet(urlPatterns = "/my/servlet")
    * 注册
        * @ServletComponentScan(basePackages = "com.imooc.demo.web.servlet")
* Filter
* Listener
### 异步Servlet
* javax.servlet.ServletRequest#startAsync()
    * 开启异步:@WebServlet(urlPatterns = "/my/servlet",asyncSupported = true)//默认asyncSupported是false
    
![异步startAsync](https://raw.githubusercontent.com/kvenLin/dive-in-spring-boot/master/src/main/resources/images/选区_019.png)

* javax.servlet.AsyncContext
### 切换其他Servlet容器
* Tomcat -> Jetty
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <!-- 将tomcat排除掉,因为不进行排除的话,tomcat加载的优先级高于其他的容器会先进行加载 -->
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<!-- 使用jetty来容器代替tomcat容器 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jetty</artifactId>
</dependency>
```
## 切换Webflux容器
直接引入依赖后还需要注意:传统的Web容器的优先级高于Webflux,
所以需要将传统的web容器的依赖进行注释
```
<!--<dependency>-->
    <!--<groupId>org.springframework.boot</groupId>-->
    <!--<artifactId>spring-boot-starter-web</artifactId>-->
    <!--<exclusions>-->
        <!-- 将tomcat排除掉,因为不进行排除的话,tomcat加载的优先级高于其他的容器会先进行加载 -->
        <!--<exclusion>-->
            <!--<groupId>org.springframework.boot</groupId>-->
            <!--<artifactId>spring-boot-starter-tomcat</artifactId>-->
        <!--</exclusion>-->
    <!--</exclusions>-->
<!--</dependency>-->

<!--使用jetty来容器代替tomcat容器 -->
<!--<dependency>-->
    <!--<groupId>org.springframework.boot</groupId>-->
    <!--<artifactId>spring-boot-starter-jetty</artifactId>-->
<!--</dependency>-->
<dependency>
    <groupId>org.springframework.boot</groupId> 
    <artifactId>spring-boot-starter-webflux</artifactId>
</dependency>
```

## Spring Framework的手动装配
* spring 模式的注解装配
* “组件”角色的注解
### 模式注解
* 层级嵌套,对使用的不同的组件定义不同含义的注解名
* @Component 
* @Service 
* @Configuration 
* @SpringBootApplication : 实际上最内层为@Component
    * @SpringBootConfiguration
        * @Configuration
            * @Component 
### Spring @Enable模块装配
* 定义: 具备相同领域的功能组件集合,组合所形成一个独立的单元
* 举例: @Enable@WebMvc,@EnableAutoConfiguration等
* 实现: 
    * 注解方式(@Import(HelloWorldConfiguration.class)),直接指定配置模块类
    * 编程方式(@Import(HelloWorldImportSelector.class),实现ImportSelector类的接口再进行导入配置模块类)
* 参考:
    * [EnableHelloWorld](http://github.com/kvenLin/dive-in-spring-boot/blob/master/autoconfig/src/main/java/com/imooc/demo/annotation/EnableHelloWorld.java)
    * [HelloWorldImportSelector](http://github.com/kvenLin/dive-in-spring-boot/blob/master/autoconfig/src/main/java/com/imooc/demo/annotation/HelloWorldImportSelector.java)
    * [HelloWorldConfiguration](http://github.com/kvenLin/dive-in-spring-boot/blob/master/autoconfig/src/main/java/com/imooc/demo/configuration/HelloWorldConfiguration.java)
### Spring 条件装配
* 定义: Bean装配的前置判断
* 举例: @Profile,@Conditional
* 实现: 
    * 注解方式
        1. 使用@Component注入Bean
        2. 同时@Profile指定
        3. 运行时指定对应的Profile类型
        * [Java7CalculateService](http://github.com/kvenLin/dive-in-spring-boot/blob/master/autoconfig/src/main/java/com/imooc/demo/service/impl/Java7CalculateService.java)
        * [Java8CalculateService](http://github.com/kvenLin/dive-in-spring-boot/blob/master/autoconfig/src/main/java/com/imooc/demo/service/impl/Java8CalculateService.java)
        * [CalculateServiceBootstrap](http://github.com/kvenLin/dive-in-spring-boot/blob/master/autoconfig/src/main/java/com/imooc/demo/bootstrap/CalculateServiceBootstrap.java)
    * 编程方式
        * 实现@Conditional标注的自定义条件注解
        [@ConditionalOnSystemProperty](http://github.com/kvenLin/dive-in-spring-boot/blob/master/autoconfig/src/main/java/com/imooc/demo/condition/ConditionalOnSystemProperty.java)
        * 实现继承Condition接口的条件判断类,同时需要在@Conditional中指定该实现类
        [OnSystemPropertyCondition](http://github.com/kvenLin/dive-in-spring-boot/blob/master/autoconfig/src/main/java/com/imooc/demo/condition/OnSystemPropertyCondition.java)
        * 使用方式:在使用@Bean进行注入时添加自定义的条件注解@ConditionalOnSystemProperty,然后添加该注解的属性的值,
        [使用示例](http://github.com/kvenLin/dive-in-spring-boot/blob/master/autoconfig/src/main/java/com/imooc/demo/bootstrap/ConditionalOnSystemPropertyBootstrap.java)
        
## SpringBoot的自动装配
 * 定义: 约定大于配置,实现Spring组件自动装配的目的
 * 装配: 模式注解,@Enable模块,条件装配,工厂加载机制
### 自定义自动装配
* 主要流程: 
    * 模式注解: @Configuration
    * @Enable 模块: @EnableHelloWorld -> HelloWorldImportSelector -> HelloWorldConfiguration - > helloWorld
    * 条件判断: user.name == "hk"
* 具体配置:
    * 先定义自己的自动装配类[HelloWorldAutoConfiguration.java](http://github.com/kvenLin/dive-in-spring-boot/blob/master/autoconfig/src/main/java/com/imooc/demo/configuration/HelloWorldAutoConfiguration.java)
    * 在装配类中添加:
        * 模式注解:@Configuration,同时添加[配置文件:spring.factories](https://raw.githubusercontent.com/kvenLin/dive-in-spring-boot/master/src/main/resources/META-INF/spring.factories)
        * [模块注解:@EnableHelloWorld](http://github.com/kvenLin/dive-in-spring-boot/blob/master/autoconfig/src/main/java/com/imooc/demo/annotation/EnableHelloWorld.java)
        * [条件注解:@ConditionalOnSystemProperty](http://github.com/kvenLin/dive-in-spring-boot/blob/master/autoconfig/src/main/java/com/imooc/demo/condition/ConditionalOnSystemProperty.java)
    * [启动类进行测试](http://github.com/kvenLin/dive-in-spring-boot/blob/master/autoconfig/src/main/java/com/imooc/demo/bootstrap/EnableAutoConfigurationBootstrap.java)
## 理解SpringApplication
### SpringApplication运行
两种方式:
* SpringApplication.run()
* new SpringApplicationBuilder().run()

### 运行阶段
* 加载: SpringApplication运行监听器
* 运行: SpringApplication运行监听器
* 监听: SpringBoot事件,Spring的事件
* 创建: 应用上下文(ApplicationContext),Environment,其他
* 失败: 故障分析报告
* 回调: CommandLineRunner,ApplicationRunner,主要用于参数的回调实现
3-14