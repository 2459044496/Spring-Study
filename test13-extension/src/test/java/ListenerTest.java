import cn.cuiper.config.MySpringConfig;
import cn.cuiper.listener.MyApplicationListener;
import cn.cuiper.listener.MyListenerSpringConfig;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.GenericApplicationListener;
import org.springframework.context.event.GenericApplicationListenerAdapter;

import java.util.Arrays;

public class ListenerTest {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                MyListenerSpringConfig.class
        );
        System.out.println("打印容器中的MyApplicationListener类型的bean:" + Arrays.toString(context.getBeanNamesForType(MyApplicationListener.class)));
        //context.publishEvent(new ApplicationEvent("发布事件") {});
        //context.publishEvent("哈哈哈");

        MyApplicationListener myApplicationListener = context.getBean("myApplicationListener", MyApplicationListener.class);
        myApplicationListener.setMsg("aaaa1111");
        context.publishEvent(myApplicationListener);


        // new 出来的不走ioc容器
        MyApplicationListener cuipai = new MyApplicationListener("cuipai");
        System.out.println("cuipai class:" + cuipai);
        context.publishEvent(cuipai);

        MyApplicationListener cccccccc = new MyApplicationListener("cccccccc");
        context.publishEvent(cccccccc);
        System.out.println("cccccccc class:" + cccccccc);


        // context.refresh();
        //context.close();
    }
}
