package cn.cuiper.config;

import cn.cuiper.pojo.Tree;
import cn.cuiper.pojo.User;
import org.springframework.beans.factory.FactoryBean;

public class TreeFactoryBean implements FactoryBean<Tree> {

    @Override
    // 返回一个对象，这个对象会放到容器中
    public Tree getObject() throws Exception {
        return new Tree();
    }

    @Override
    // 返回的对象类型
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
