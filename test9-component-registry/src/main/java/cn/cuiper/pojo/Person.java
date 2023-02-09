package cn.cuiper.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
public class Person {

    private String name;

    private Integer age;

    public Person() {
        System.out.println("执行Person无参构造方法");
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
