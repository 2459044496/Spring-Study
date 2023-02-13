package cn.cuiper.lifecycle.pojo;

import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
public class User implements InitializingBean, DisposableBean {

    private String name;

    private Integer age;

    public User() {
        System.out.println("执行User无参构造方法");
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("执行User(String, Integer)有参构造方法");
    }

    static {
        System.out.println("执行User静态代码块");
    }

    private void userInit() {
        System.out.println("执行userInit方法");
    }

    private void userDestroy() {
        System.out.println("执行userDestroy方法");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("执行DisposableBean接口destroy方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行InitializingBean接口afterPropertiesSet方法");
    }

    @PostConstruct// JSR250注解
    // CommonAnnotationBeanPostProcessor和InitDestroyAnnotationBeanPostProcessor实现
    public void postConstruct() {
        System.out.println("执行java @PostConstruct注解方法");
    }

    @PreDestroy// JSR250注解
    public void preDestroy() {
        System.out.println("执行java @PreDestroy注解方法");
    }


}
