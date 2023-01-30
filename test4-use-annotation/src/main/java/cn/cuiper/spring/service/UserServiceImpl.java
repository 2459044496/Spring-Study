package cn.cuiper.spring.service;

import cn.cuiper.spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{

/*    @Autowired// 根据类型进行装配
    @Qualifier("userDaoImpl2")
    // @Qualifier根据名称注入，当接口有多个实现类时，根据类型注入将报错，需要指定bean名称，
    // 需要和@Autowired一起使用
    private UserDao userDao;*/

    //@Resource// 根据类型
    @Resource(name = "userDaoImpl2")// 根据名称
    // @Resource是java注解，不推荐使用
    private UserDao userDao;

    @Value("cuipai")// 注入普通类型属性
    private String name;

    @Override
    public void add() {
        System.out.println("service add..." + name);
        userDao.add();
    }
}
