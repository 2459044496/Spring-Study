package cn.cuiper.config;

import cn.cuiper.pojo.Person;
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

}
