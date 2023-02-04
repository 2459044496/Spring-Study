package cn.cuiper;

import cn.cuiper.config.SpringConfig;
import cn.cuiper.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/*@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfig.class)*/
@SpringJUnitConfig(classes = SpringConfig.class)// 复合注解，效果和上面两个相同
public class Junit5Test {

    @Autowired
    private UserService userService;

    @Test // 包路径 import org.junit.jupiter.api.Test;
    public void test() {
        userService.hello();
    }
}
