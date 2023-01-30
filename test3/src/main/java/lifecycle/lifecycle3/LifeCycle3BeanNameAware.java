package lifecycle.lifecycle3;

import org.springframework.beans.factory.BeanNameAware;

public class LifeCycle3BeanNameAware implements BeanNameAware {

    @Override
    public void setBeanName(String name) {
        System.out.println("3.执行LifeCycle3BeanNameAware.setBeanName");
    }
}
