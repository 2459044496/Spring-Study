package cn.cuiper;

import cn.cuiper.config.MySpringConfig;
import cn.cuiper.pojo.Person;
import cn.cuiper.pojo.User;
import cn.cuiper.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MySpringConfig.class)
public class Test2 {

    // PersonServiceImpl 通过@Import注解导入
    // bean容器存储的名称 cn.cuiper.service.impl.PersonServiceImpl
    // @Autowired根据类型注入
    @Autowired
    private PersonService personService;

    @Autowired
    private ApplicationContext context;

    @Test
    public void test1() {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
        Map<String, PersonService> beansOfType = context.getBeansOfType(PersonService.class);
        for (String s : beansOfType.keySet()) {
            System.out.println(s + "\t" + beansOfType.get(s));
        }
        personService.say();

    }
}
