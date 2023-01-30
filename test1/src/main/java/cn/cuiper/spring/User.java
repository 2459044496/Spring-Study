package cn.cuiper.spring;

public class User {

    private String name;

    private Integer age;

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Java默认会有无参构造方法，如果新写了构造方法，默认的则会没有，
    // 这时spring需要使用constructor-arg标签给构造方法传值，否则使用bean时会报错
    // No default constructor found; nested exception is java.lang.NoSuchMethodException: cn.cuiper.spring.User.<init>()
    /*public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }*/

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
