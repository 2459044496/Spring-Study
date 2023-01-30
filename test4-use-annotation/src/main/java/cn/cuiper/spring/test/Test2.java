package cn.cuiper.spring.test;

import cn.cuiper.spring.config.SpringConfig;
import cn.cuiper.spring.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {

    public static void main(String[] args) {
        // 不使用xml，只使用注解
        ApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class);
        UserServiceImpl userService = context.getBean("userServiceImpl", UserServiceImpl.class);
        userService.add();
    }
}
