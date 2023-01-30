package lifecycle.lifecycle3;

public class LifeCycle3 {

    private String name;

    public void setName(String name) {
        this.name = name;
        System.out.println("2.调用set方法设置bean的属性及对其他bean的引用");
    }

    public LifeCycle3() {
        System.out.println("1.执行构造方法");
    }

    public void initMethod() {
        System.out.println("7.执行initMethod方法");
    }

    public void destroyMethod() {
        System.out.println("10.执行destroyMethod方法");
    }
}
