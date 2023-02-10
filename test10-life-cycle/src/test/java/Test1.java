import cn.cuiper.lifecycle.config.MySpringConfig;
import cn.cuiper.lifecycle.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MySpringConfig.class)
public class Test1 {

    @Autowired
    private ApplicationContext context;

    @Test
    public void test1() {
        User user = context.getBean("user", User.class);

        // 手动关闭容器 registerShutdownHook();
        if (context instanceof AbstractApplicationContext) {
            ((AbstractApplicationContext) context).registerShutdownHook();
        }
    }
}
