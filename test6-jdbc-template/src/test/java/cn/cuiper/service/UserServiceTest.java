package cn.cuiper.service;

import cn.cuiper.config.SpringConfig;
import cn.cuiper.projo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void test(){
        User user = new User();
        user.setId(100);
        user.setName("cui");
        user.setPwd("666");
        userService.add(user);
    }
}
