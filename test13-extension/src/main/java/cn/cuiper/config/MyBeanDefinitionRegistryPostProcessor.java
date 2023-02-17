package cn.cuiper.config;

import com.alibaba.druid.util.H2Utils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    // 在所有bean定义信息将要被加载，bean实例还未创建。
    // 在BeanFactoryPostProcessor的postProcessBeanFactory()方法执行之前。
    // 可以利用beanDefinitionRegistryPostProcessor给容器中再注册bean。
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        System.out.println("BeanDefinitionCount:" + beanDefinitionRegistry.getBeanDefinitionCount());
        // 移除bean
        // beanDefinitionRegistry.removeBeanDefinition("user");

        // 手动注册bean
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(
                com.alibaba.druid.DruidRuntimeException.class);
        beanDefinitionRegistry.registerBeanDefinition("myDefineDruidBean", rootBeanDefinition);

        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(
                H2Utils.class).getBeanDefinition();
        beanDefinitionRegistry.registerBeanDefinition("defieH2Utils", beanDefinition);

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
