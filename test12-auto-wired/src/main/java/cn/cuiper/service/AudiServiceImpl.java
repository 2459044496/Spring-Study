package cn.cuiper.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Service;
import org.springframework.util.StringValueResolver;

@Service
// 自定义组件想要使用Spring容器底层的一些组件（例如ApplicationContext、BeanFactory、BeanName等），
// 实现xxxAware接口，在创建对象的时候，会调用接口规定的方法，注入相应的组件。
// EmbeddedValueResolverAware接口; String值解析器（可以解析String、SpEL表达式、环境变量值、配置文件值）
public class AudiServiceImpl implements CarService, ApplicationContextAware, EmbeddedValueResolverAware {

    private ApplicationContext context;

    @Override
    public void back() {
        System.out.println("奥迪。。倒车。。");
        System.out.println("context:" + context);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("执行ApplicationContextAware接口setApplicationContext方法");
        this.context = applicationContext;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String str = resolver.resolveStringValue("test: #{ 10 * 2} ==== ${os.name} .");
        System.out.println(str);
    }
}
