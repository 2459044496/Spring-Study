package cn.cuiper;

import cn.cuiper.config.MySpringConfig;
import cn.cuiper.pojo.Person;
import cn.cuiper.pojo.Tree;
import cn.cuiper.pojo.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Test {

    @org.junit.Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                MySpringConfig.class
        );
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println("\n==============print beanDefinitionNames start================");
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
        System.out.println("==============print beanDefinitionNames end================\n");

        System.out.println("\n==============print getBeanNamesForType start================");
        String[] beanNamesForType = context.getBeanNamesForType(User.class);
        Arrays.stream(beanNamesForType).forEach(System.out::println);
        System.out.println("==============print getBeanNamesForType end================\n");


        Person person = context.getBean("person", Person.class);
        System.out.println(person);
        Person person2 = context.getBean("person2", Person.class);
        System.out.println(person2);

        System.out.println("==== start   tree ====");
        Object tree = context.getBean("tree");
        System.out.println(tree);
        Object bean = context.getBean("&tree");
        System.out.println(bean);

        System.out.println("\n==============print getBeanNamesForType User start================");
        String[] beanNamesForType1 = context.getBeanNamesForType(User.class);
        Arrays.stream(beanNamesForType1).forEach(System.out::println);
        System.out.println("==============print getBeanNamesForType User end================\n");

    }
}
