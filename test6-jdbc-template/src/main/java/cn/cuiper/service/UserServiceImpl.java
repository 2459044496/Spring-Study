package cn.cuiper.service;

import cn.cuiper.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cuiper.projo.User;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;


    @Override
    public void add(User user) {
        userDao.add(user);
    }
}
