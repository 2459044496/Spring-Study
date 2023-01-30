package aspectj.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "aspectj")// 扫描包
@EnableAspectJAutoProxy()
// 开启AOP,默认使用jdk动态代理,proxyTargetClass属性为ture使用cglib
public class SpringConfig {
}
