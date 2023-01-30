package factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "factorybean-test.xml");
        User user = context.getBean("facBean", User.class);
        System.out.println(user);
    }
}
