package factorybean;

import org.springframework.beans.factory.FactoryBean;

// FactoryBean bean的返回类型可以与定义bean的类型不一致
public class FacBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        User user = new User();
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
