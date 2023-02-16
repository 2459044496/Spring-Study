package jdkproxy;

import org.junit.Test;
import org.springframework.aop.framework.ReflectiveMethodInvocation;

import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JdkproxyTest {

    @Test
    public void test() {
        User user = new UserImpl();
        System.out.println("interfaces:" + Arrays.toString(ReflectiveMethodInvocation.class.getInterfaces()));
        User proxy = (User) getProxy(user);
        proxy.say();
        System.out.println(proxy.hashCode());
        System.out.println(proxy.add(8, 22));
    }

    public static Object getProxy(Object obj) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new UserInvocationHandler(obj));
    }
}
