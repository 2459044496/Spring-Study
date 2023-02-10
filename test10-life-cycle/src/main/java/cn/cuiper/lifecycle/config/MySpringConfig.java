package cn.cuiper.lifecycle.config;

import cn.cuiper.lifecycle.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "cn.cuiper.lifecycle")
public class MySpringConfig {

    @Bean(initMethod = "userInit", destroyMethod = "userDestroy")
    public User user() {
        return new User();
    }
}
