package cn.cuiper.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:user.properties")
@ComponentScan(basePackages = "cn.cuiper")
public class MySpringConfig {
}
