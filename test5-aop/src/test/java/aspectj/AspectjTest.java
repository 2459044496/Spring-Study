package aspectj;

import aspectj.config.SpringConfig;
import aspectj.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AspectjTest {

    @Autowired
    private BookService bookService;

    @Test
    public void test(){
        //bookService.add();
        Long aLong = bookService.addNum(3, 5);
        System.out.println(aLong);
    }
}
