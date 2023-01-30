package jdkproxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class JdkproxyTest {

    @Test
    public void test() {
        User user = new UserImpl();
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
