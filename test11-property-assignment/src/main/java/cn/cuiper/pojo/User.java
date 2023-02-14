package cn.cuiper.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data// @Value注解不需要get、set方法，这里是为了使用toString();
// SpringBoot读取配置文件通常使用@ConfigurationProperties注解，可以解析Map、List等复杂类型
public class User {

    @Value("cuipai")
    private String name;

    // 配置文件、环境变量值
    @Value("${user.pwd}")
    private String pwd;

    // : 如果找不到配置，则使用:后的值。如果没有默认值为对应的表达式，本例为${user.null}
    @Value("${user.null:IAMNULL}")
    private String testNull;

    // SpEL表达式
    @Value("#{1+2}")
    private String a;

}
