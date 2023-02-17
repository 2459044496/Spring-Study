import cn.cuiper.config.MySpringConfig;
import cn.cuiper.pojo.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MySpringConfig.class)
public class PostProcessorTest {

    @Autowired
    private ApplicationContext context;

    @Autowired(required = false)
    private User user;

    @org.junit.Test
    public void test1() {
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

    }
}
