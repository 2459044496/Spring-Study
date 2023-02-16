package aspectj.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Aspect// 使用Aspect  @Aspect注解将类声明为切面
@Configuration
@Order(1)// 设置切面优先级，数字低优先级高
public class AopConfig {

    // 带有通知注解的方法，都可以加入一个JoinPoint类型的参数，可以通过该参数获取当前代理的方法名称、方法参数列表等信息。

    @Pointcut(value = "execution(* aspectj.service.*.*(..))")
    // @Pointcut("@annotation(org.aspectj.lang.annotation.After)")
    // 处理被指定注解的类，Aspect支持10种表达式，SpringAop只支持method
    public void pointCut(){}

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("前置通知输出方法参数:" + Arrays.toString(joinPoint.getArgs()));
        System.out.println("AOP Before.前置通知");
    }

    // @AfterReturning注解带有returning属性，可以在方法的参数中定义一个代理方法的返回结果参数，
    // 将该参数名指定到@AfterReturning的returning属性上，方法运行的结果便会赋值给该参数。
    @AfterReturning(value = "pointCut()", returning = "returnRes")
    public void afterReturning(JoinPoint joinPoint, Object returnRes) {
        System.out.println("AOP AfterReturning.返回通知");
        System.out.println("返回通知打印方法结果为:" + returnRes);
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("AOP After.最终通知");
    }

    // @AfterThrowing注解带有throwing属性，可以在方法的参数中定义一个异常参数，
    // 将该参数名指定到@AfterThrowing的throwing属性上，便可以通过该参数获取方法运行中出现的异常。
    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        System.out.println("AOP afterThrowing.异常通知");
        System.out.println("方法[" + joinPoint.getSignature().toString() +"]执行异常,异常信息为" + e.getMessage());
    }

    // 这种环绕通知会导致实际方法无法调用，包括其他通知
    // 结果为
    // AOP Around.环绕通知前
    // AOP Around.环绕通知后
    /*@Around("pointCut()")
    public void around() {
        System.out.println("AOP Around.环绕通知前");

        System.out.println("AOP Around.环绕通知后");
    }*/


    // 如果方法返回类型是void，那么被切入方法永远返回null,这里使用Object
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("AOP Around.环绕通知前");
        Object[] args = joinPoint.getArgs();// 获取方法参数
        Object result = joinPoint.proceed();

        //Object result = joinPoint.proceed(new Object[]{1, 2}); 环绕通知甚至可以修改方法参数
        System.out.println("AOP Around.环绕通知后");
        return result;
    }

}
