package cn.cuiper.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

public class UseAware implements ApplicationContextAware, EmbeddedValueResolverAware {

    private ApplicationContext context;

    public UseAware() {
        System.out.println("执行UseAware构造方法");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("UseAware执行ApplicationContextAware接口setApplicationContext方法");
        this.context = applicationContext;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String str = resolver.resolveStringValue("test: #{ 10 * 2} ==== ${os.name} .");
        System.out.println("UseAware setEmbeddedValueResolver:" + str);
    }

}
