package cn.cuiper.config;

import lombok.SneakyThrows;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @SneakyThrows
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        // 根据条件手动注册bean
        boolean b = registry.containsBeanDefinition("cn.cuiper.pojo.Account");
        System.out.println("MyImportBeanDefinitionRegistrar registerBeanDefinitions 结果是" + b);
        if (!b) {
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Class.forName("cn.cuiper.pojo.Account"));
            registry.registerBeanDefinition("account", rootBeanDefinition);
        }
    }
}
