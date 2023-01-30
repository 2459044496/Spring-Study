package lifecycle.lifecycle2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycle2Test {

    //（1）通过构造器创建 bean 实例（无参数构造）
    //（2）为 bean 的属性设置值和对其他 bean 引用（调用 set 方法）
    //（3）把 bean 实例传递 bean 后置处理器的方法 postProcessBeforeInitialization
    //（4）调用 bean 的初始化的方法（需要进行配置初始化的方法）
    //（5）把 bean 实例传递 bean 后置处理器的方法 postProcessAfterInitialization
    //（6）bean 可以使用了（对象获取到了）
    //（7）当容器关闭时候，调用 bean 的销毁的方法（需要进行配置销毁的方法）
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "lifecycle2.xml");
        LifeCycle2 lifeCycle = context.getBean("lifeCycle2", LifeCycle2.class);
        System.out.println("6.获取bean实例");
        // ApplicationContext接口没有close()，所以需要强转，或者直接使用
        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("lifecycle1.xml");
        ((ClassPathXmlApplicationContext)context).close();
    }
}
