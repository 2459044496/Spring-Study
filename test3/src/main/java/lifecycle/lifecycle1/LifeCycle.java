package lifecycle.lifecycle1;

public class LifeCycle {

    private String name;

    public void setName(String name) {
        this.name = name;
        System.out.println("2.调用set方法设置bean的属性及对其他bean的引用");
    }

    public LifeCycle() {
        System.out.println("1.执行构造方法");
    }

    public void initMethod() {
        System.out.println("3.执行initMethod方法");
    }

    public void destroyMethod() {
        System.out.println("5.执行destroyMethod方法");
    }
}
