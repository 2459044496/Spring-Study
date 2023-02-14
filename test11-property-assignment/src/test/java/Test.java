import cn.cuiper.config.MySpringConfig;
import cn.cuiper.pojo.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MySpringConfig.class)
public class Test {

    @Autowired
    private User user;

    @org.junit.Test
    public void test1() {
        System.out.println(user);
    }
}
