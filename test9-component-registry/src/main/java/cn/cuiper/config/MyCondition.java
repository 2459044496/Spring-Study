package cn.cuiper.config;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        // 获取ioc使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 获取到bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();
        ResourceLoader resourceLoader = context.getResourceLoader();
        metadata.getAnnotations().stream().forEach(System.out::println);

        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println("os.name值为: " + property);
        return property.startsWith("Windows");
    }
}
