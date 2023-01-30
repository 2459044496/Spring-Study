package cn.cuiper.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-config-4.xml");
        Emp emp = (Emp) context.getBean("emp");
        System.out.println(emp);
    }
}
