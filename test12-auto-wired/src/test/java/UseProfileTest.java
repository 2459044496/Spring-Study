import cn.cuiper.config.MySpringConfig;
import cn.cuiper.profile.UseProfile;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

public class UseProfileTest {

    // 通过JVM参数配置 -Dspring.profiles.active=test

    @org.junit.Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                MySpringConfig.class);
        context.getEnvironment().setActiveProfiles("prod", "test");

        // @TODO 不调用该方法@Profile对类级别配置无效
        context.register(UseProfile.class);

        System.out.println("激活的配置:" +
                Arrays.toString(context.getEnvironment().getActiveProfiles()));

        System.out.println("useProfile存在容器中?" +
                context.containsBean("useProfile"));

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
