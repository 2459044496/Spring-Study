package scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "scope-test.xml");
        Scope scope1 = context.getBean("scope", Scope.class);
        Scope scope2 = context.getBean("scope", Scope.class);
        System.out.println(scope1);
        System.out.println(scope2);

        // Spring默认作用域是singleton单例，会在加载配置文件时初始化
        // prototype多实例，getBean时初始化。类的hash值不同

    }
}
