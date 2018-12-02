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
## SpringBoot的自动装配
### Spring Framework的手动装配
* spring 模式的注解装配
* “组件”角色的注解
#### 模式注解
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
* 实现: 注解方式,编程方式
* 参考:
    * [EnableHelloWorld](http://github.com/kvenLin/dive-in-spring-boot/master/src/main/java/com/imooc/demo/annotation/EnableHelloWorld.java)
    * [HelloWorldImportSelector](http://github.com/kvenLin/dive-in-spring-boot/master/src/main/java/com/imooc/demo/annotation/HelloWorldImportSelector.java)
    * [HelloWorldConfiguration](http://github.com/kvenLin/dive-in-spring-boot/master/src/main/java/com/imooc/demo/configuration/HelloWorldConfiguration.java)
- 2-5