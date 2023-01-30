import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeptTest2 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-config2.xml");
        Dept dept = context.getBean("dept", Dept.class);
        System.out.println(dept);
    }
}
