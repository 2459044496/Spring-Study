package cn.cuiper.tx;

import cn.cuiper.tx.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class TxXmlTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        userService.addMoney(100);
    }

}
