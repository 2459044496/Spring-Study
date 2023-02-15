import cn.cuiper.aware.UseAware;
import cn.cuiper.config.MySpringConfig;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MySpringConfig.class)
public class UseAwareTest {

    @Autowired
    private UseAware useAware;

    @org.junit.Test
    public void test() {
    }
}
