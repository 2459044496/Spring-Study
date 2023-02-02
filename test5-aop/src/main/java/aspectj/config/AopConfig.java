package aspectj.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Aspect// 使用Aspect  @Aspect注解将类声明为切面
@Configuration
@Order(1)// 设置切面优先级，数字低优先级高
public class AopConfig {

    @Pointcut(value = "execution(* aspectj.service.*.*(..))")
    // @Pointcut("@annotation(org.aspectj.lang.annotation.After)")
    // 处理被指定注解的类，Aspect支持10种表达式，SpringAop只支持method
    public void pointCut(){}

    @Before("pointCut()")
    public void before() {
        System.out.println("AOP Before.前置通知");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("AOP AfterReturning.返回通知");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("AOP After.最终通知");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("AOP afterThrowing.异常通知");
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
