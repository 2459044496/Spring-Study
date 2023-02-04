package cn.cuiper;

import org.springframework.lang.Nullable;

public class UseNullableAnnotation {

    @Nullable // 属性可以为null
    public String name;

    @Nullable // 方法返回值可以为null
    public void test() {}

    // 方法参数可以为null
    public Object test2(@Nullable Object param) {
        return null;
    }

}
