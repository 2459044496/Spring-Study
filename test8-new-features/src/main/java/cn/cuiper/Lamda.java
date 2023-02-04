package cn.cuiper;

import org.springframework.context.support.GenericApplicationContext;

// 函数式风格编程
public class Lamda {

    public static void main(String[] args) {
        // 1.创建对象
        GenericApplicationContext context = new GenericApplicationContext();
        // 2.对象注册
        context.refresh();

        /*
        注册bean
        context.registerBean(TestLog.class,()->new TestLog());
        通过类全路径获取bean
        TestLog testLog = (TestLog)context.getBean("TestLog");
        */

        // 注册bean并指定bean名称
        context.registerBean("definedName", TestLog.class,()->new TestLog());
        TestLog testLog = (TestLog)context.getBean("definedName");

        System.out.println(testLog);
    }
}
