package cn.cuiper.service;

import cn.cuiper.config.SpringConfig;
import cn.cuiper.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void test(){
        User user = new User();
        user.setId(102);
        user.setName("pai");
        user.setPwd("888");
        userService.add(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(100);
        user.setName("pai");
        user.setPwd("888");
        userService.update(user);
    }

    @Test
    public void testDelById(){
        userService.delById(100);
    }

    @Test
    public void testGetCount(){
        System.out.println(userService.getCount());
    }

    @Test
    public void testSelById(){
        System.out.println(userService.selById(100));
    }

    @Test
    public void testSelAllUser(){
        System.out.println(userService.selAllUser());
    }

    @Test
    public void testBatchAddUser(){
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(i);
            userList.add(user);
        }
        userService.batchAddUser(userList);
    }

    @Test
    public void testBatchUpdateUser(){
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(i);
            user.setName("c");
            user.setPwd("666");
            userList.add(user);
        }
        userService.batchUpdateUser(userList);
    }
}
