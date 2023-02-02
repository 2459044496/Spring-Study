package cn.cuiper.tx.service;

import cn.cuiper.tx.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public Boolean addMoney(int addMoney) {
        return userDao.addMoney(addMoney);
    }

    @Override
    public void testPlatformTransactionManager() {
        userDao.testPlatformTransactionManager();
    }

    @Override
    public void testTransactionTemplate() {
        userDao.testTransactionTemplate();
    }
}
