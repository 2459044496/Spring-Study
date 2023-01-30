package cn.cuiper.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = "cn.cuiper")// 扫描包
@ImportResource("classpath:druid.xml")// 引入xml配置
public class SpringConfig {
}
