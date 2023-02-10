package cn.cuiper.config;

import cn.cuiper.pojo.Person;
import cn.cuiper.pojo.Tree;
import cn.cuiper.pojo.User;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(value = {"cn.cuiper"})
public class MySpringConfig {

    // 自定义过滤器，需要先禁用系统默认的 useDefaultFilters = false
    // useDefaultFilters = false,
    //        includeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})

    // 不包含
    // excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Repository.class)}

    @Bean(value = "person")
    @Scope(value = "singleton")
    @Lazy(value = true)// 单例bean 懒加载（第一次使用bean时才创建对象初始化）
    public Person person() {
        return new Person();
    }

    @Bean()
    public User user() {
        return new User();
    }

    @Bean(value = "person2")
    @Conditional(MyCondition.class)
    public Person person2() {
        return new Person();
    }

    @Bean(value = "tree")
    public TreeFactoryBean tree() {
        //  方法 context.getBeanNamesForType(Tree.class); 结果为null，
        //  因为TreeFactoryBean覆写的getObjectType()方法返回类型为 User.class
        return new TreeFactoryBean();

        // 在获取tree这个Bean时，实际获取到的bean对象的类型是ColorFactoryBean::getObjectType()返回的类型，即User类型。
        // 获取到的Bean对象是ColorFactoryBean::getObject()创建的对象。
        //
        //如果想要获取TreeFactoryBean类型的bean对象，需要在BeanID前添加前缀&，即&tree。
        // 这个前缀是在BeanFactory.FACTORY_BEAN_PREFIX中定义的。
    }

}
