package autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 自动装配 autowire
// byName 和 byType
public class AutoWireTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "autowire.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}
