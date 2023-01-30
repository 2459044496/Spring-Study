package lifecycle.lifecycle3;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class LifeCycle3BeanPostProcess implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("6.执行postProcessBeforeInitialization方法");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("8.执行postProcessAfterInitialization方法");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
