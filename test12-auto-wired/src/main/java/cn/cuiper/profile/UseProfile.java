package cn.cuiper.profile;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")// 类的配置高于方法
public class UseProfile {

    @Profile("test")
    @Bean
    public UseProfile useProfile() {
        return new UseProfile();
    }
}
