package cn.cuiper.spring.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service(value = "userService")// 默认类名，首字母小写
// 注解等同于<bean id="userService" class="cn.cuiper.spring.service.UserService">
/* 四个注解作用相同，便于区分 代码所属层 controller、service、dao
@Controller
@Component
@Repository*/
public interface UserService {

    public void add();
}
