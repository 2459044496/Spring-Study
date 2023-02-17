package cn.cuiper.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("执行MyBeanPostProcessor postProcessBeforeInitialization, beanName为:" + beanName);
        System.out.println(bean.getClass().getName());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("执行MyBeanPostProcessor postProcessAfterInitialization, beanName为:" + beanName);
        return null;
    }
}
