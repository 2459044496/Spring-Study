package cn.cuiper.config;

import cn.cuiper.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "cn.cuiper")
public class MySpringConfig {

    @Bean
    public User user() {
        return new User();
    }
}
