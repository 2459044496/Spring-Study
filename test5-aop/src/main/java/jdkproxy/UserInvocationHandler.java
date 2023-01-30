package jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class UserInvocationHandler implements InvocationHandler {

    private Object obj;

    public UserInvocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk代理调用方法前,方法名:" + method.getName() + ";方法参数:" + Arrays.toString(args));
        Object invoke = method.invoke(obj, args);
        System.out.println("jdk代理调用方法完成");
        return invoke;
    }
}
